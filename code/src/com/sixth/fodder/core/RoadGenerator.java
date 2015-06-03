/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core;

import com.sixth.fodder.core.buildings.*;
import com.sixth.fodder.core.cell.*;
import static demogen.DemoGen.generate;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sixth
 */
public class RoadGenerator 
{
    private static final int mapWidth = 10;
    private static final int mapHeight = 20;
    private static final Random random = new Random();
    
    private static Cell[][] cells;

    public RoadGenerator() 
    {
        byte [][] map = generate (mapHeight, mapWidth, 2, 1.4f, 0.3f);
        
        cells = new Cell[mapHeight][mapWidth];
        
        for (int i = 0; i < mapHeight; ++i)
            for (int j = 0; j < mapWidth; ++j)
            {
                if (map[i][j] == 0)
                {
                    cells[i][j] = new BackCell(i, j);
                }
                else 
                {
                    cells[i][j] = new RoadCell(i, j, map[i][j]);
                }
                cells[i][j].setTexture();
            }
        
        
//        for (int i = 0; i < mapHeight; ++i)
//            for (int j = 0; j < mapWidth; ++j)
//            {
//                if (map[i][j] == 0)
//                    cells[i][j] = new BackCell(i, j);
//            }

        ArrayList<Integer> buildCells = new ArrayList<>();
        
//        for (int i = 0; i < mapHeight; ++i)
//            for (int j = 0; j < mapWidth; ++j)
//            {
//                String name = cells[i][j].getActor().getTexture().toString();
//                if (((name.equals("uRoad"))||
//                        (name.equals("dRoad")) ||
//                        (name.equals("lRoad")) ||
//                        (name.equals("rRoad")))
//                    buildCells.add(i * mapWidth + j);
//            }

        Building[] builds = new Building[6];
        for (int i = 0; i < 3; ++i)
            builds[i] = new House();
        for (int i = 3; i < 6; ++i)
            builds[i] = new Cafe();
        
        int numOfBuildings = Building.getNextId();
        while (numOfBuildings > 0)
        {
            int x = random.nextInt(mapHeight);
            int y = random.nextInt(mapWidth);
            if (map[x][y] == 0)
            {
                if (
                        (x > 0) && 
                        (map[x-1][y] > 0) && 
                        (((RoadCell)(cells[x-1][y])).hasLeftRoad() || ((RoadCell)(cells[x-1][y])).hasRightRoad())
                        )
                {
                    ((RoadCell)(cells[x-1][y])).setDownRoad(true);
                    cells[x][y] = new BuildingCell(x, y, builds[numOfBuildings - 1]);
                    numOfBuildings--;
                    map[x][y] = -1;
                }
                else if ((x < mapHeight - 1) && (map[x+1][y] > 0) && 
                        (((RoadCell)(cells[x+1][y])).hasLeftRoad() || ((RoadCell)(cells[x+1][y])).hasRightRoad()))
                {
                    ((RoadCell)(cells[x+1][y])).setUpRoad(true);
                    cells[x][y] = new BuildingCell(x, y, builds[numOfBuildings - 1]);
                    numOfBuildings--;
                    map[x][y] = -1;
                }
                else if ((y > 0) && (map[x][y-1] > 0) && 
                        (((RoadCell)(cells[x][y-1])).hasUpRoad() || ((RoadCell)(cells[x][y-1])).hasDownRoad()))
                {
                    ((RoadCell)(cells[x][y-1])).setRightRoad(true);
                    cells[x][y] = new BuildingCell(x, y, builds[numOfBuildings - 1]);
                    numOfBuildings--;
                    map[x][y] = -1;
                }
                else if ((y < mapWidth - 1) && (map[x][y+1] > 0) && 
                        (((RoadCell)(cells[x][y+1])).hasUpRoad() || ((RoadCell)(cells[x][y+1])).hasDownRoad()))
                {
                    ((RoadCell)(cells[x][y+1])).setLeftRoad(true);
                    cells[x][y] = new BuildingCell(x, y, builds[numOfBuildings - 1]);
                    numOfBuildings--;
                    map[x][y] = -1;
                }
            }
        }
          
        
        for (int i = 0; i < mapHeight; i++)
            for (int j = 0; j < mapWidth; j++)
                cells[i][j].setTexture();
//        int n = buildCells.size();
//        for (int i = 0; i < numOfBuildings; ++i)
//        {
//            int choice = random.nextInt(n);
//            int coord = buildCells.remove(choice);
//            cells[coord / mapWidth][coord % mapWidth];
//        }
    }
    
    public static Cell[][] getCells() 
    {
        return cells;
    }

    public static int getMapHeight()
    {
        return mapHeight;
    }

    public static int getMapWidth()
    {
        return mapWidth;
    }
}
