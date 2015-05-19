/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core;

import com.sixth.fodder.core.buildings.House;
import com.sixth.fodder.core.cell.*;
import demogen.Constants;
import static demogen.DemoGen.generate;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sixth
 */
public class RoadGenerator 
{
    private static final int numOfCells = 64;
    private static final Random random = new Random();
    
    private static Cell[][] cells;
    private static ArrayList<Integer> cellsQueue;
    private static GraphAnalyser gA;

    public RoadGenerator() 
    {
        cellsQueue = new ArrayList<>();
        gA = new GraphAnalyser();

        cells = new Cell[numOfCells][numOfCells];
//        for (int i = 0; i < numOfCells; ++i)
//            for (int j = 0; j < numOfCells; ++j)
//                cells[i][j] = new BackCell(i, j);
        
        byte [][] map = generate (numOfCells, numOfCells, 2, 1.4f, 0.3f);
        
        for (int i = 0; i < numOfCells; ++i)
            for (int j = 0; j < numOfCells; ++j)
            {
                if (map[i][j] == 0)
                    cells[i][j] = new BackCell(i, j);
                else 
                {
                    cells[i][j] = new RoadCell(i, j);
                    ((RoadCell)cells[i][j]).setUpRoad(Constants.Type.values()[map[i][j]].isLeft());
                    ((RoadCell)cells[i][j]).setDownRoad(Constants.Type.values()[map[i][j]].isRight());
                    ((RoadCell)cells[i][j]).setLeftRoad(Constants.Type.values()[map[i][j]].isUp());
                    ((RoadCell)cells[i][j]).setRightRoad(Constants.Type.values()[map[i][j]].isDown());
                }
            }
             
        for (int i = 0; i < numOfCells; ++i)
            for (int j = 0; j < numOfCells; ++j)
               cells[i][j].setTexture();
//        setNeighbours();
        
        //                setTexture
    }
    
    private void setNeighbours()
    {
        for (int i = 0; i < numOfCells; ++i)
            for (int j = 0; j < numOfCells; ++j)
            {
                if (cells[i][j].rightAvail())
                    cells[i][j].setRightCell(cells[i][j+1]);
                if (cells[i][j].leftAvail())
                    cells[i][j].setLeftCell(cells[i][j-1]);
                if (cells[i][j].downAvail())
                    cells[i][j].setDownCell(cells[i+1][j]);
                if (cells[i][j].upAvail())
                    cells[i][j].setUpCell(cells[i-1][j]);
            }
    }
    
//    private void generate(int[][] map, int x, int y)
//    {
//        // maximum length of road - 3
//        int topMargin = 12;
//        // cells left to build
//        int roadLen;
//        // the direction of building
//        int dir;
//        // last chosen direction
//        int lastDir = -1;
//        // number of buildings left to build
//        int numOfBuildings = 5;
//        // current road cells coordinates
//        ArrayList<Integer> lastRoad = new ArrayList<Integer>();
//        
//        // start with placing a building
//        map[x][y] = -1;
//        System.out.println("build " + x + " " + y);
//        numOfBuildings--;
//        
//        while (numOfBuildings > 0)
//        {
//            // between 3 and 15
//            roadLen = random.nextInt(topMargin) + 3;
//            
//            // new direction should be perpendicular to the last direction
//            do
//            {
//                dir = random.nextInt(4);
//            } while ((((dir == 0) || (dir == 1)) && (lastDir == 1)) ||
//                    (((dir == 1) || (dir == 0)) && (lastDir == 0)) ||
//                    (((dir == 2) || (dir == 3)) && (lastDir == 3)) ||
//                    (((dir == 3) || (dir == 2))&& (lastDir == 2)));
//            
//            // making the road
//            while (roadLen > 0)
//                // up
//                if (dir == 0)
//                    while (roadLen > 0)
//                        if ((x > 0) && (map[x-1][y] != -1))
//                        {
//                            x--;
//                            if (map[x][y] / 8 == 0)
//                                map[x][y] += 8;
//                            lastRoad.add(x);
//                            lastRoad.add(y);
//                            roadLen--;
//                            System.out.println("up " + x + " " + y);
//                        }
//                        else
//                        {
//                            dir = 3;
//                            break;
//                        }
//                // down
//                else if (dir == 1) 
//                    while (roadLen > 0)
//                        if ((x < (numOfCells - 1)) && (map[x+1][y] != -1))
//                        {
//                            x++;
//                            int res = map[x][y];
//                            if (res > 8)
//                                res -= 8;
//                            if (res / 4 == 0)
//                                map[x][y] += 4;
//                            lastRoad.add(x);
//                            lastRoad.add(y);
//                            roadLen--;
//                            System.out.println("down " + x + " " + y);
//                        }
//                        else
//                        {
//                            dir = 2;
//                            break;
//                        }
//                // left
//                else if (dir == 2)
//                    while (roadLen > 0)
//                        if ((y > 0) && (map[x][y-1] != -1))
//                        {
//                            y--;
//                            int res = map[x][y];
//                            if (res > 8)
//                                res -= 8;
//                            if (res > 4)
//                                res -= 4;
//                            if (res / 2 == 0)
//                                map[x][y] += 2;
//                            lastRoad.add(x);
//                            lastRoad.add(y);
//                            roadLen--;
//                            System.out.println("left " + x + " " + y);
//                        }
//                        else
//                        {
//                            dir = 0;
//                            break;
//                        }
//                // right
//                else if (dir == 3)
//                    while (roadLen > 0)
//                    {
//                        if ((y < (numOfCells - 1)) && (map[x][y+1] != -1))
//                        {
//                            y++;
//                            if (map[x][y] % 2 == 0)
//                                map[x][y] += 1;
//                            lastRoad.add(x);
//                            lastRoad.add(y);
//                            roadLen--;
//                            System.out.println("right " + x + " " + y);
//                        }
//                        else
//                        {
//                            dir = 1;
//                            break;
//                        }
//                    }
//
//            // the pribability of placing a building (25 %)
//            int build = random.nextInt(4);
//            int nextX, nextY;
//
//            if (build == 0)
//            {
//                // last cell of road is a building
//                int coord = lastRoad.size();
//                y = lastRoad.remove(coord-1);
//                coord--;
//                x = lastRoad.remove(coord-1);
//                System.out.println("build " + x + " " + y);
//                map[x][y] = -1;
//                coord = lastRoad.size();
//                coord /= 2;
//                coord = random.nextInt(coord) * 2;
//                x = lastRoad.remove(coord);
//                y = lastRoad.remove(coord);
//                numOfBuildings--;
//                System.out.println("new road starts at " + x + " " + y);
//            }
//            else
//            {
//                int coord = lastRoad.size();
//                coord /= 2;
//                coord = random.nextInt(coord) * 2;
//                x = lastRoad.remove(coord);
//                y = lastRoad.remove(coord);
//                System.out.println("new road starts at " + x + " " + y);
//            }
//            lastRoad.clear();
//            lastDir = dir;
//        }
//        
//        for (int i = 0; i < numOfCells; ++i)
//            for (int j = 0; j < numOfCells; ++j)
//            {
//                // up
//                if (i == 0)
//                {
//                    if (map[i][j] / 8 == 1)
//                        map[i][j] -= 8;
//                }
//                else
//                {
//                    int curr = map[i][j];
//                    int new = map[i-1][j];
//                    if ((new / 8 == 1) && (curr / 8 == 0))
//                        
//                }
//                // left
//                if ((j == 0))
//                {
//                    int res = map[i][j];
//                    if (res > 8)
//                        res -= 8;
//                    if (res > 4)
//                        res -= 4;
//                    if (res / 2 == 1)
//                        map[i][j] -= 2;
//                }
//                // down
//                if (i == (numOfCells - 1))
//                {
//                    int res = map[i][j];
//                    if (res > 8)
//                        res -= 8;
//                    if (res / 4 == 1)
//                        map[i][j] -= 4;
//                }
//                // right
//                if ((j == (numOfCells - 1)) && (map[i][j] % 2 == 1))
//                        map[i][j] -= 1;
//            }                    
//    }
    
    public static Cell[][] getCells() 
    {
        return cells;
    }
    
    public static int getNumOfCells() 
    {
        return numOfCells;
    }
}
