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
    
    private Cell up;
    private Cell down;
    private Cell left;
    private Cell right;
    
    private final CellActor actor;
    
    private Boolean checked;;
        
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        actor = new CellActor();
        actor.setSize(sizeInPix, sizeInPix);
        actor.setPosition(y * sizeInPix, (RoadGenerator.getNumOfCells() - x - 1) * sizeInPix);
    }
    
    public abstract void setTexture();
    
    // mutators
    
    public void setUp(Cell up)
    {
        this.up = up;
    }

    public void setDown(Cell down)
    {
        this.down = down;
    }
    
    public void setLeft(Cell left)
    {
        this.left = left;
    }
    
    public void setRight(Cell right)
    {
        this.right = right;
    }
    
    // accessors
    
    public CellActor getActor ()
    {
        return actor;
    }
    
    public static int getSizeInPix()
    {
        return sizeInPix;
    }

    public Cell getUp()
    {
        return up;
    }

    public Cell getDown()
    {
        return down;
    }

    public Cell getLeft()
    {
        return left;
    }

    public Cell getRight()
    {
        return right;
    }
    
    public Boolean upAvail()
    {
        return (up != null);
    }
    
    public Boolean downAvail()
    {
        return (down != null);
    }
    
    public Boolean leftAvail()
    {
        return (left != null);
    }
    
    public Boolean rightAvail()
    {
        return (right != null);
    }
}
