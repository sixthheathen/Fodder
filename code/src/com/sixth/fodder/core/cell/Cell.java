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

    private final int x;
    private final int y;
    
    
    private final CellActor actor;
        
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
        
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

    public static int getNumOfCells()
    {
        return numOfCells;
    }
}
