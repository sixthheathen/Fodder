/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.graphics.atlasses.Road;

/**
 *
 * @author sixth
 */
public class RoadCell extends Cell

{
    RoadCell (int x, int y)
    {
        super(x, y);
    }
    
    public void setTexture()
    {
        if (super.getUp().exists())
            if (super.getDown().exists())
                if (super.getLeft().exists())
                    if (super.getRight().exists())
                        super.getActor().setTexture(Road.valueOf("udlrRoad").getTexture());
                    else
                        super.getActor().setTexture(Road.valueOf("udlRoad").getTexture());
                else 
                {
                    if (super.getRight().exists())
                        super.getActor().setTexture(Road.valueOf("udrRoad").getTexture());
                    else 
                        super.getActor().setTexture(Road.valueOf("udRoad").getTexture());
                }
            else 
            {
                if (super.getLeft().exists())
                    if (super.getRight().exists())
                        super.getActor().setTexture(Road.valueOf("ulrRoad").getTexture());
                    else
                        super.getActor().setTexture(Road.valueOf("ulRoad").getTexture());
                else 
                {
                    if (super.getRight().exists())
                        super.getActor().setTexture(Road.valueOf("urRoad").getTexture());
                    else 
                        super.getActor().setTexture(Road.valueOf("uRoad").getTexture());
                }
            }
        else
        {
            if (super.getDown().exists())
                if (super.getLeft().exists())
                    if (super.getRight().exists())
                        super.getActor().setTexture(Road.valueOf("dlrRoad").getTexture());
                    else
                        super.getActor().setTexture(Road.valueOf("dlRoad").getTexture());
                else 
                {
                    if (super.getRight().exists())
                        super.getActor().setTexture(Road.valueOf("drRoad").getTexture());
                    else 
                        super.getActor().setTexture(Road.valueOf("dRoad").getTexture());
                }
            else 
            {
                if (super.getLeft().exists())
                    if (super.getRight().exists())
                        super.getActor().setTexture(Road.valueOf("lrRoad").getTexture());
                    else
                        super.getActor().setTexture(Road.valueOf("lRoad").getTexture());
                else 
                {
                    if (super.getRight().exists())
                        super.getActor().setTexture(Road.valueOf("rRoad").getTexture());
                    else 
                        super.getActor().setTexture(BackCells.valueOf("voidCell".getTexture()));
                }
            }
        }
    }
}
