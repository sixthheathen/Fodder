/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.graphics.CellActor;

/**
 *
 * @author sixth
 */
public abstract class Cell 
{
    private final static int sizeInPix = 64;

//    private final Direction up;
//    private final Direction down;
//    private final Direction left;
//    private final Direction right;
    
    private final int x;
    private final int y;
    
//    private Building building;
    
    private final CellActor actor;
        
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
        
//        up = new Direction(0b1000, "u", (x != 0));
//        down = new Direction (0b0100, "d", (x != (RoadGenerator.getNumOfCells() - 1)));
//        left = new Direction (0b0010, "l", (y != 0));
//        right = new Direction (0b0001, "r", (y != (RoadGenerator.getNumOfCells() - 1)));
//        
//        building = null;
        
        actor = new CellActor();
        actor.setSize(sizeInPix, sizeInPix);
//        actor.setPosition(y * sizeInPix, (RoadGenerator.getNumOfCells() - x - 1) * sizeInPix);
//        actor.setTexture(composeName());
    }
    
    public abstract void setTexture();
    
    public CellActor getActor ()
    {
        return actor;
    }
}
