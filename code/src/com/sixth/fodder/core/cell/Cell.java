/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.core.RoadGenerator;
import com.sixth.fodder.graphics.CellActor;

/**
 *
 * @author sixth
 */
public abstract class Cell 
{
    private final static int sizeInPix = 64;

    private final int x;
    private final int y;
    
    private final Direction up;
    private final Direction down;
    private final Direction left;
    private final Direction right;
    
    private final CellActor actor;
    
    private Boolean checked;;
        
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        up = new Direction(x != 0);
        down = new Direction(x != (RoadGenerator.getNumOfCells() - 1));
        left = new Direction(y != 0);
        right = new Direction(y != (RoadGenerator.getNumOfCells() - 1));
        
        actor = new CellActor();
        actor.setSize(sizeInPix, sizeInPix);
        actor.setPosition(y * sizeInPix, (RoadGenerator.getNumOfCells() - x - 1) * sizeInPix);
    }
    
    public abstract void setTexture();
    
    // accessors
    
    public CellActor getActor ()
    {
        return actor;
    }
    
    public static int getSizeInPix()
    {
        return sizeInPix;
    }

    public Direction getUp()
    {
        return up;
    }

    public Direction getDown()
    {
        return down;
    }

    public Direction getLeft()
    {
        return left;
    }

    public Direction getRight()
    {
        return right;
    }
}
