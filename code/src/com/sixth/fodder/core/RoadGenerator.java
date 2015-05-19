/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core;

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
    private static final int mapWidth = 100;
    private static final int mapHeight = 64;
    private static final Random random = new Random();
    
    private static Cell[][] cells;
    private static GraphAnalyser gA;

    public RoadGenerator() 
    {
        byte [][] map = generate (mapHeight, mapWidth, 2, 1.4f, 0.3f);
        
        cells = new Cell[mapHeight][mapWidth];

        for (int i = 0; i < mapHeight; ++i)
            for (int j = 0; j < mapWidth; ++j)
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
             
        for (int i = 0; i < mapHeight; ++i)
            for (int j = 0; j < mapWidth; ++j)
               cells[i][j].setTexture();
//        setNeighbours();
        
        //                setTexture
    }
    
    private void setNeighbours()
    {
        for (int i = 0; i < mapHeight; ++i)
            for (int j = 0; j < mapWidth; ++j)
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
