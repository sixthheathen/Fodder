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
    private final static int numOfCells = 64;

    private final Direction up;
    private final Direction down;
    private final Direction left;
    private final Direction right;
    
    private final int x;
    private final int y;
    
//    private Building building;
    
    private final CellActor actor;
        
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        up = new Direction(x != 0);
        down = new Direction (x != (numOfCells - 1));
        left = new Direction (y != 0);
        right = new Direction (y != (numOfCells - 1));
        
//        building = null;
        
        actor = new CellActor();
        actor.setSize(sizeInPix, sizeInPix);
        actor.setPosition(y * sizeInPix, (numOfCells - x - 1) * sizeInPix);
        setTexture();
    }
    
    public abstract void setTexture();
    
    // accessors
    
    public CellActor getActor ()
    {
        return actor;
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
