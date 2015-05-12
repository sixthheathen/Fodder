/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.graphics.atlasses.*;

/**
 *
 * @author sixth
 */
public class RoadCell extends Cell

{
    private final Direction up;
    private final Direction down;
    private final Direction left;
    private final Direction right;
    
    RoadCell (int x, int y)
    {
        super(x, y);
        
        up = new Direction(x != 0);
        down = new Direction (x != (super.getNumOfCells() - 1));
        left = new Direction (y != 0);
        right = new Direction (y != (super.getNumOfCells() - 1));
    }
    
    @Override
    public void setTexture()
    {
        if (up.exists())
            if (down.exists())
                if (left.exists())
                    if (right.exists())
                        super.getActor().setTexture(Roads.valueOf("udlrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("udlRoad").getTexture());
                else 
                {
                    if (right.exists())
                        super.getActor().setTexture(Roads.valueOf("udrRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("udRoad").getTexture());
                }
            else 
            {
                if (left.exists())
                    if (right.exists())
                        super.getActor().setTexture(Roads.valueOf("ulrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("ulRoad").getTexture());
                else 
                {
                    if (right.exists())
                        super.getActor().setTexture(Roads.valueOf("urRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("uRoad").getTexture());
                }
            }
        else
        {
            if (down.exists())
                if (left.exists())
                    if (right.exists())
                        super.getActor().setTexture(Roads.valueOf("dlrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("dlRoad").getTexture());
                else 
                {
                    if (right.exists())
                        super.getActor().setTexture(Roads.valueOf("drRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("dRoad").getTexture());
                }
            else 
            {
                if (left.exists())
                    if (right.exists())
                        super.getActor().setTexture(Roads.valueOf("lrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("lRoad").getTexture());
                else 
                {
                    if (right.exists())
                        super.getActor().setTexture(Roads.valueOf("rRoad").getTexture());
                    else 
                        super.getActor().setTexture(BackCells.valueOf("voidCell").getTexture());
                }
            }
        }
    }
}
