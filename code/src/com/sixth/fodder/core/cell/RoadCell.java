
package com.sixth.fodder.core.cell;

import com.sixth.fodder.graphics.atlasses.*;

/**
 *
 * @author sixth
 */
public class RoadCell extends Cell

{
    private Boolean up;
    private Boolean down;
    private Boolean left;
    private Boolean right;
    
    public RoadCell (int x, int y)
    {
        super(x, y);
        
        up = (x != 0);
        down = (x != (super.getNumOfCells() - 1));
        left = (y != 0);
        right = (y != (super.getNumOfCells() - 1));
    }
    
    @Override
    public void setTexture()
    {
        if (up)
                if (down)
                if (left)
                    if (right)
                        super.getActor().setTexture(Roads.valueOf("udlrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("udlRoad").getTexture());
                else 
                {
                    if (right)
                        super.getActor().setTexture(Roads.valueOf("udrRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("udRoad").getTexture());
                }
            else 
            {
                if (left)
                    if (right)
                        super.getActor().setTexture(Roads.valueOf("ulrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("ulRoad").getTexture());
                else 
                {
                    if (right)
                        super.getActor().setTexture(Roads.valueOf("urRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("uRoad").getTexture());
                }
            }
        else
        {
            if (down)
                if (left)
                    if (right)
                        super.getActor().setTexture(Roads.valueOf("dlrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("dlRoad").getTexture());
                else 
                {
                    if (right)
                        super.getActor().setTexture(Roads.valueOf("drRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("dRoad").getTexture());
                }
            else 
            {
                if (left)
                    if (right)
                        super.getActor().setTexture(Roads.valueOf("lrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("lRoad").getTexture());
                else 
                {
                    if (right)
                        super.getActor().setTexture(Roads.valueOf("rRoad").getTexture());
                    else 
                        super.getActor().setTexture(BackCells.valueOf("voidCell").getTexture());
                }
            }
        }
    }
}
