package demogen;

import java.util.Random;

/**
 *
 * @author pagan
 */
public class DemoGen {
    
    public static byte[][] generate(int x, int y, int shortesRoad, float filling, float fearfulness)
    {
        byte [][] map = new byte [x][y];
     
        Feodor fedja = new Feodor(map, x / 2, y / 2, shortesRoad, fearfulness);
        
        Random rand = new Random(System.currentTimeMillis());
        int steps_to_pass = (int) (rand.nextInt(x * y) * filling);
        
        fedja.doTheJob (steps_to_pass);
        
        return map;
    }
}
