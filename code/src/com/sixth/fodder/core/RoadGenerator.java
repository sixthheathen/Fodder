/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core;

import com.sixth.fodder.core.buildings.Building;
import com.sixth.fodder.core.cell.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sixth
 */
public class RoadGenerator 
{
    private static final int numOfCells = Cell.getNumOfCells();
    private static final int centerCoord = numOfCells / 2;
//    private static final int numOfRoadTypes = 16;
    private static final Random random = new Random();
    private static Cell[][] cells;
    private static ArrayList<Cell> cellsQueue;

    public RoadGenerator() 
    {
        cells = new Cell[numOfCells][numOfCells];
        for (int i = 0; i < numOfCells; ++i)
            for (int j = 0; j < numOfCells; ++j)
                cells[i][j] = new BackCell(i,j);
        
        setNeighbours();
        
        cellsQueue = new ArrayList<>();
    }
    
    private void setNeighbours()
    {
        for (int i = 0; i < numOfCells; ++i)
            for (int j = 0; j < numOfCells; ++j)
            {
                if (cells[i][j].getRight().exists())
                    cells[i][j].getRight().setCell(cells[i][j+1]);
                if (cells[i][j].getLeft().exists())
                    cells[i][j].getLeft().setCell(cells[i][j-1]);
                if (cells[i][j].getDown().exists())
                    cells[i][j].getDown().setCell(cells[i+1][j]);
                if (cells[i][j].getUp().exists())
                    cells[i][j].getUp().setCell(cells[i-1][j]);
            }
    }
    
    // call strictly before generating roads
    public void placeBuildings(Building[] buildings)
    {
        for (int i = 0; i < Building.getNextId(); ++i)
        {
            // setting the house
            int x, y;
            do 
            {
                x = random.nextInt(numOfCells);
                y = random.nextInt(numOfCells);    
            } while (((x == centerCoord) && (y == centerCoord)) || buildingsAround(x, y));
            cells[x][y].setHouse(Buildings[i]);
            cells[x][y].setAllFalse();
            cells[x][y].isChecked(true);
                        
            // choosing the direction of the road to the house
//            int dir = 0b0;
//            Cell cell = null;
//            if (x < centerCoord)
//            {
//                dir += cells[x][y].getDown().getId();
//                cell = cells[x+1][y];
//            }
//            else if (x > centerCoord)
//            {
//                dir += cells[x][y].getUp().getId();
//                cell = cells[x-1][y];
//            }
//            if (y < centerCoord)
//            {
//                dir += cells[x][y].getRight().getId();
//                cell = cells[x][y+1];
//            }
//            else if (y > centerCoord)
//            {
//                dir += cells[x][y].getLeft().getId();
//                cell = cells[x][y-1];
//            }
//            genRoadType(dir, cell.getAvailId());
//            cell.
//            cellsQueue.add(cell);
        }
    }
    
//    private int genRoadType (int initType, int availType)
//    {
//        int type  = initType;
//        
//        do
//        {
//            type = random.nextInt(numOfRoadTypes - 1) + 1;
//            
//            if (type & )
//            switch (dir)
//                {
//                    case 0:
//                        if (cells[x][y].isUp())
//                            break;
//                    case 1:
//                        if (cells[x][y].isDown())
//                            break;
//                    case 2:
//                        if (cells[x][y].isLeft())
//                            break;
//                    case 3:
//                        if (cells[x][y].isRight())
//                            break;
//                    default:
//                        dir = -1;
//                        break;
//                }
//        } while (dir < 0);
//    }
    
    public void letsMakeRoads()
    {
        
    }
    
    // checks if there are any building in 8 surrounding cells
    private Boolean buildingsAround (int x, int y)
    {
        if (cells[x][y].getUp().exists())
        {
            if (cells[x-1][y] instanceof BuildingCell)
                return true;
            if (cells[x][y].getLeft().exists())
                if (cells[x-1][y-1] instanceof BuildingCell)
                    return true;
            if (cells[x][y].getRight().exists())       
                if (cells[x-1][y+1] instanceof BuildingCell)
                    return true;
        }
        if (cells[x][y].getLeft().exists())
            if (cells[x][y-1] instanceof BuildingCell)
                return true;
        if (cells[x][y].getDown().exists())
        {
            if (cells[x+1][y] instanceof BuildingCell)
                    return true;
            if (cells[x][y].getLeft().exists())
                if (cells[x+1][y-1] instanceof BuildingCell)
                    return true;
            if (cells[x][y].getRight().exists())
                if (cells[x+1][y+1] instanceof BuildingCell)
                return true;         
        }
        if (cells[x][y].getRight().exists())
            if (cells[x][y+1] instanceof BuildingCell)
                return true;
        
        return false;
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
