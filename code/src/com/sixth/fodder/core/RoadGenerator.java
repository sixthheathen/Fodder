/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core;

import com.sixth.fodder.core.cell.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sixth
 */
public class RoadGenerator 
{
    private static final int numOfCells = 64;
    private static final int centerCoord = numOfCells / 2;
    private static final Random random = new Random();
    
    private static Cell[][] cells;
    private static ArrayList<Integer> cellsQueue;

    public RoadGenerator() 
    {
        cellsQueue = new ArrayList<>();

        cells = new Cell[numOfCells][numOfCells];
        for (int i = 0; i < numOfCells; ++i)
            for (int j = 0; j < numOfCells; ++j)
                cells[i][j] = new RoadCell(i,j);
        
        setNeighbours();
        
//        letsMakeRoads(16, 16);
//        letsMakeRoads(48, 48);
//        letsMakeRoads(16, 48);
//        letsMakeRoads(48, 16);
        letsMakeRoads(32, 32);
        
        for (int i = 0; i < numOfCells; ++i)
            for (int j = 0; j < numOfCells; ++j)
                cells[i][j].setTexture();
        
        
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
    
    private void genRoadType(int x, int y)
    {
        Boolean bool;
        
        if (cells[x][y].upAvail() && !((RoadCell)cells[x][y]).hasUpRoad())
        {
            int r = random.nextInt(5);
            if (r == 0 || r == 1)
                bool = true;
            else
                bool = false;
//            bool = random.nextBoolean();
            ((RoadCell)cells[x][y]).setUpRoad(bool);
            if (bool)
            {
                cellsQueue.add(x-1);
                cellsQueue.add(y);
            }
        }
        if (cells[x][y].downAvail() && !((RoadCell)cells[x][y]).hasDownRoad())
        {
            int r = random.nextInt(5);
            if (r == 0 || r == 1)
                bool = true;
            else
                bool = false;
//            bool = random.nextBoolean();
            ((RoadCell)cells[x][y]).setDownRoad(bool);
            if (bool)
            {
                cellsQueue.add(x+1);
                cellsQueue.add(y);
            }
        }
        if (cells[x][y].leftAvail() && !((RoadCell)cells[x][y]).hasLeftRoad())
        {
            int r = random.nextInt(5);
            if (r == 0 || r == 1)
                bool = true;
            else
                bool = false;
//            bool = random.nextBoolean();
            ((RoadCell)cells[x][y]).setLeftRoad(bool);
            if (bool)
            {
                cellsQueue.add(x);
                cellsQueue.add(y-1);
            }
        }
        if (cells[x][y].rightAvail() && !((RoadCell)cells[x][y]).hasRightRoad())
        {
            int r = random.nextInt(5);
            if (r == 0 || r == 1)
                bool = true;
            else
                bool = false;
//            bool = random.nextBoolean();
            ((RoadCell)cells[x][y]).setRightRoad(bool);
            if (bool)
            {
                cellsQueue.add(x);
                cellsQueue.add(y+1);
            }
        }
    }
    
    private void letsMakeRoads(int initX, int initY)
    {
        // initial cell should have all four roads
        ((RoadCell)cells[initX][initY]).setUpRoad(true);
        ((RoadCell)cells[initX][initY]).setDownRoad(true);
        ((RoadCell)cells[initX][initY]).setLeftRoad(true);
        ((RoadCell)cells[initX][initY]).setRightRoad(true);
        
        // four nearby cells are added to the queue (if exist)
        if (cells[initX][initY].upAvail())
        {
            cellsQueue.add(initX-1);
            cellsQueue.add(initY);
        }
        if (cells[initX][initY].downAvail())
        {
            cellsQueue.add(initX+1);
            cellsQueue.add(initY);
        }
        if (cells[initX][initY].leftAvail())
        {
            cellsQueue.add(initX);
            cellsQueue.add(initY-1);
        }
        if (cells[initX][initY].rightAvail())
        {
            cellsQueue.add(initX);
            cellsQueue.add(initY+1);
        }
        
        do
        {
            genRoadType(cellsQueue.remove(0), cellsQueue.remove(0));
        }
        while (!cellsQueue.isEmpty());
    }
 
    public static Cell[][] getCells() 
    {
        return cells;
    }
    
    public static int getNumOfCells() 
    {
        return numOfCells;
    }
}
