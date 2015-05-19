/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.core.RoadGenerator;
import com.sixth.fodder.core.buildings.House;
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
    
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        actor = new CellActor();
        actor.setSize(sizeInPix, sizeInPix);
        actor.setPosition(y * sizeInPix, (RoadGenerator.getNumOfCells() - x - 1) * sizeInPix);
    }
    
    public abstract void setTexture();
    
    public void create(int typeId, Cell cell)
    {
        switch (typeId)
        {
            case 0:
            {
                cell = new BackCell(cell.x, cell.y);
                break;
            }
            case 1:
            {
                cell = new BuildingCell(cell.x, cell.y, new House());
                break;
            }
            case 2:
            {
                cell = new RoadCell(cell.x, cell.y);
                break;
            }
            default:
            {
                //this is never gonna happen
            }
        }
    }
    
    // mutators
    
    public void setUpCell(Cell up)
    {
        this.up = up;
    }

    public void setDownCell(Cell down)
    {
        this.down = down;
    }
    
    public void setLeftCell(Cell left)
    {
        this.left = left;
    }
    
    public void setRightCell(Cell right)
    {
        this.right = right;
    }
    
    // accessors
    
    public CellActor getActor()
    {
        return actor;
    }
    
    public static int getSizeInPix()
    {
        return sizeInPix;
    }

    public Cell getUpCell()
    {
        return up;
    }

    public Cell getDownCell()
    {
        return down;
    }

    public Cell getLeftCell()
    {
        return left;
    }

    public Cell getRightCell()
    {
        return right;
    }
    
    public Boolean upAvail()
    {
        return (x != 0);
    }
    
    public Boolean downAvail()
    {
        return (x != (RoadGenerator.getNumOfCells() - 1));
    }
    
    public Boolean leftAvail()
    {
        return (y != 0);
    }
    
    public Boolean rightAvail()
    {
        return (y != (RoadGenerator.getNumOfCells() - 1));
    }
}
