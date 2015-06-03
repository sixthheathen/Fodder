/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.core.RoadGenerator;
import com.sixth.fodder.core.man.Man;
import com.sixth.fodder.graphics.CellActor;
import java.util.ArrayList;

/**
 *
 * @author sixth
 */
public abstract class Cell 
{
    private final static int sizeInPix = 64;

    private final CellActor actor;
    
    private final int x;
    private final int y;
    
    private final ArrayList<Man> people;
    
    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
        actor = new CellActor();
        actor.setSize(sizeInPix, sizeInPix);
        actor.setPosition(y * sizeInPix, (RoadGenerator.getMapHeight() - x - 1) * sizeInPix);
        people = new ArrayList<>();
    }
    
    public abstract void setTexture();
    
    // accessors
    
    public CellActor getActor()
    {
        return actor;
    }
    
    public static int getSizeInPix()
    {
        return sizeInPix;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
