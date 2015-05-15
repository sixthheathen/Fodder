
package com.sixth.fodder.core.cell;

import com.sixth.fodder.graphics.atlasses.*;

/**
 *
 * @author sixth
 */
public class RoadCell extends Cell
{
    private Boolean upRoad;
    private Boolean downRoad;
    private Boolean leftRoad;
    private Boolean rightRoad;
    
    public RoadCell (int x, int y)
    {
        super(x, y);
        
//        upRoad = (x != 0);
//        downRoad = (x != (RoadGenerator.getNumOfCells() - 1));
//        leftRoad = (y != 0);
//        rightRoad = (y != (RoadGenerator.getNumOfCells() - 1));
        
        upRoad = downRoad = leftRoad = rightRoad = false;
        
        setTexture();
    }
    
    @Override
    public void setTexture()
    {
        if (upRoad)
            if (downRoad)
                if (leftRoad)
                    if (rightRoad)
                        super.getActor().setTexture(Roads.valueOf("udlrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("udlRoad").getTexture());
                else 
                {
                    if (rightRoad)
                        super.getActor().setTexture(Roads.valueOf("udrRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("udRoad").getTexture());
                }
            else 
            {
                if (leftRoad)
                    if (rightRoad)
                        super.getActor().setTexture(Roads.valueOf("ulrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("ulRoad").getTexture());
                else 
                {
                    if (rightRoad)
                        super.getActor().setTexture(Roads.valueOf("urRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("uRoad").getTexture());
                }
            }
        else
        {
            if (downRoad)
                if (leftRoad)
                    if (rightRoad)
                        super.getActor().setTexture(Roads.valueOf("dlrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("dlRoad").getTexture());
                else 
                {
                    if (rightRoad)
                        super.getActor().setTexture(Roads.valueOf("drRoad").getTexture());
                    else 
                        super.getActor().setTexture(Roads.valueOf("dRoad").getTexture());
                }
            else 
            {
                if (leftRoad)
                    if (rightRoad)
                        super.getActor().setTexture(Roads.valueOf("lrRoad").getTexture());
                    else
                        super.getActor().setTexture(Roads.valueOf("lRoad").getTexture());
                else 
                {
                    if (rightRoad)
                        super.getActor().setTexture(Roads.valueOf("rRoad").getTexture());
                    else 
                        super.getActor().setTexture(BackCells.valueOf("voidCell").getTexture());
                }
            }
        }
    }

    public Boolean hasUpRoad()
    {
        return upRoad;
    }

    public Boolean hasDownRoad()
    {
        return downRoad;
    }

    public Boolean hasLeftRoad()
    {
        return leftRoad;
    }

    public Boolean hasRightRoad()
    {
        return rightRoad;
    }

    public void setUpRoad(Boolean bool)
    {
        this.upRoad = bool;
      if (bool && !(((RoadCell)(super.getUp())).hasDownRoad()))
            ((RoadCell)super.getUp()).setDownRoad(bool);
    }

    public void setDownRoad(Boolean bool)
    {
        this.downRoad = bool;
        if (bool && !((RoadCell)super.getDown()).hasUpRoad())
            ((RoadCell)super.getDown()).setUpRoad(bool);
    }

    public void setLeftRoad(Boolean bool)
    {
        this.leftRoad = bool;
        if (bool && !((RoadCell)super.getDown()).hasRightRoad())
            ((RoadCell)super.getLeft()).setRightRoad(bool);
    }

    public void setRightRoad(Boolean bool)
    {
        this.rightRoad = bool;
        if (bool && ((RoadCell)super.getRight()).hasLeftRoad())
            ((RoadCell)super.getRight()).setLeftRoad(bool);
    }
}
