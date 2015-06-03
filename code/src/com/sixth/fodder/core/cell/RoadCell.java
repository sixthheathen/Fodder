package com.sixth.fodder.core.cell;

import com.sixth.fodder.graphics.atlasses.*;
import static demogen.Constants.Type.*;

/**
 *
 * @author sixth
 */
public class RoadCell extends Cell
{
    private final boolean[] dirs;

    public RoadCell(int x, int y, byte type)
    {
        super(x, y);
        dirs = new boolean[4];
        getTypeById(type).fillMask(dirs);
    }

    @Override
    public void setTexture()
    {
        byte currType = getTypeByDirections(dirs).getId();
        switch (currType)
        {
            case 1:
                super.getActor().setTexture(Roads.valueOf("rRoad").getTexture());
                break;
            case 2:
                super.getActor().setTexture(Roads.valueOf("lRoad").getTexture());
                break;
            case 3:
                super.getActor().setTexture(Roads.valueOf("lrRoad").getTexture());
                break;
            case 4:
                super.getActor().setTexture(Roads.valueOf("dRoad").getTexture());
                break;
            case 5:
                super.getActor().setTexture(Roads.valueOf("drRoad").getTexture());
                break;
            case 6:
                super.getActor().setTexture(Roads.valueOf("dlRoad").getTexture());
                break;
            case 7:
                super.getActor().setTexture(Roads.valueOf("dlrRoad").getTexture());
                break;
            case 8:
                super.getActor().setTexture(Roads.valueOf("uRoad").getTexture());
                break;
            case 9:
                super.getActor().setTexture(Roads.valueOf("urRoad").getTexture());
                break;
            case 10:
                super.getActor().setTexture(Roads.valueOf("ulRoad").getTexture());
                break;
            case 11:
                super.getActor().setTexture(Roads.valueOf("ulrRoad").getTexture());
                break;
            case 12:
                super.getActor().setTexture(Roads.valueOf("udRoad").getTexture());
                break;
            case 13:
                super.getActor().setTexture(Roads.valueOf("udrRoad").getTexture());
                break;
            case 14:
                super.getActor().setTexture(Roads.valueOf("udlRoad").getTexture());
                break;
            case 15:
                super.getActor().setTexture(Roads.valueOf("udlrRoad").getTexture());
                break;
            default:
                System.out.println("ftw?!");
        }
    }

    public boolean hasUpRoad()
    {
        return dirs[0];
    }
    
    public boolean hasDownRoad()
    {
        return dirs[1];
    }
    
    public boolean hasLeftRoad()
    {
        return dirs[2];
    }
    
    public boolean hasRightRoad()
    {
        return dirs[3];
    }
    
    public void setUpRoad(boolean val)
    {
        dirs[0] = val;
    }
    
    public void setDownRoad(boolean val)
    {
        dirs[1] = val;
    }
    
    public void setLeftRoad(boolean val)
    {
        dirs[2] = val;
    }
    
    public void setRightRoad(boolean val)
    {
        dirs[3] = val;
    }
}
