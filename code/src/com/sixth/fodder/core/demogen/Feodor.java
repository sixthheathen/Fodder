/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demogen;

import com.sixth.fodder.core.RoadGenerator;
import demogen.Constants.Direction;
import java.util.Random;

/**
 *
 * @author pagan
 */
public class Feodor 
{
    Random brainDamage = new Random(System.currentTimeMillis());
    byte [][] map;
    int x;
    int y;
    
    int shortestRoad;
    int maxRoadLength;
    float fearfulness;

    public Feodor (byte[][] map, int x, int y, int shortestRoad, float fearfulness)
    {
        this.x = x;
        this.y = y;
        this.map = map;
        this.shortestRoad = shortestRoad;
        int size = x;
        maxRoadLength = size - shortestRoad;
        maxRoadLength = (int) (1 + (maxRoadLength) * fearfulness);
    }

    
    
    void doTheJob(int steps_to_pass) 
    {
        int stepsLeft = steps_to_pass;
        while (stepsLeft != 0)
        {
            int planned_road_size = shortestRoad + brainDamage.nextInt(maxRoadLength);
            
            if (stepsLeft - planned_road_size < 0)
            {
                planned_road_size = stepsLeft;
            }
            
            int direction = brainDamage.nextInt(4);
            Direction master_directrion = Direction.values()[direction];
        
            int done = trace(planned_road_size, master_directrion);
            
            stepsLeft -= done;
        }
        
        
    }
    
    private int trace (int steps , Direction dir)
    {
        int gone = 0;
        while (gone != steps)
        {    
            if (step(dir))
            {
                gone ++;
            }
            else
            {
                break;
            }
        }

        return gone;
    }
    
    private boolean step (Direction dir)
    {
        if( isRelevant(dir) )
        {
            build (dir);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private int nextCoordY (Direction dir)
    {
        switch (dir)
        {
            case LEFT: 
            {
                return y - 1;
            }
            case RIGHT: 
            {
                return y + 1;
            }
        }
        return y;
    }
    
    private int nextCoordX (Direction dir)
    {
        switch (dir)
        {
            case UP: 
            {
                return x - 1;
            }
            case DOWN: 
            {
                return x + 1;
            }
        }
        return x;
    }
    
    private void build (Direction dir)
    {
        int n_x = nextCoordX(dir);
        int n_y = nextCoordY(dir);
        byte type_from = map[x][y];
        Constants.Type from = Constants.Type.getTypeById(type_from);
       
        byte type_to = map[n_x][n_y];
        Constants.Type to = Constants.Type.getTypeById(type_to);
        
        boolean [] from_mask = {false, false, false, false};
        boolean []   to_mask = {false, false, false, false};
    
        from.fillMask(from_mask);
          to.fillMask(to_mask);
      
        dir.applyCurMask(from_mask);
        dir.applyNewMask(to_mask);
        
        map[x][y] = Constants.Type.getTypeByDirections(from_mask).id;
        map[n_x][n_y] = Constants.Type.getTypeByDirections(to_mask).id;
        
        x = n_x;
        y = n_y; 
    }
    
    
    private boolean isRelevant (Direction dir)
    {
        
        switch (dir)
        {
            case UP: 
            {
                if ((x - 1) < 0) return false;
                break;
            }
            case DOWN: 
            {
                if ((x + 1) >= RoadGenerator.getMapHeight()) return false;
                break;
            }
            case LEFT: 
            {
                if ((y - 1) < 0) return false;
                break;
            }
            case RIGHT: 
            {
                if ((y + 1) >= RoadGenerator.getMapWidth()) return false;
                break;
            }
        }
        return true;
    }
}
