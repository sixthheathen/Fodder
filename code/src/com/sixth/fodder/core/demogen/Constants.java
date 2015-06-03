/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demogen;

/**
 *
 * @author pagan
 */
public class Constants {
    
    enum Direction {
        UP (true,false,false,false,    false,true,false,false, (byte)8),
        DOWN(false,true,false,false,    true,false,false,false, (byte)4),
        LEFT(false,false,true,false,    false,false,false,true, (byte)2),
        RIGHT(false,false,false,true,    false,false,true,false, (byte)1);
        
        final boolean [] cur_mask;
        final boolean [] new_mask;
        final byte val;
        
        Direction(
                  boolean cur_up, 
                  boolean cur_down, 
                  boolean cur_left, 
                  boolean cur_right,
                  boolean new_up, 
                  boolean new_down, 
                  boolean new_left, 
                  boolean new_right,
                  byte val) 
        {
            cur_mask = new  boolean[4];
            new_mask = new  boolean[4];
            
            cur_mask[0] = cur_up;
            cur_mask[1] = cur_down;
            cur_mask[2] = cur_left;
            cur_mask[3] = cur_right;
            
            new_mask[0] = new_up;
            new_mask[1] = new_down;
            new_mask[2] = new_left;
            new_mask[3] = new_right;   
            
            this.val = val;
        }
        
        public void applyCurMask (boolean [] mask)
        {
            for (int i = 0; i < cur_mask.length; i ++)
            {
                if (cur_mask[i])
                {
                    mask[i] = true;
                }
            }
        }
        
        public void applyNewMask (boolean [] mask)
        {
            for (int i = 0; i < new_mask.length; i ++)
            {
                if (new_mask[i])
                {
                    mask[i] = true;
                }
            }
        }

        public byte getVal()
        {
            return val;
        }
    }
    
    public enum Type 
    {
        NONE (false, false, false, false, (byte)0,' '),//0
        
        ROAD_LR(false, false, true, true, (byte)3,'═'), //1 // 3
        ROAD_UD(true, true, false, false, (byte)12,'║'), //2 // 12
        
        TURN_UL(true, false, true, false, (byte)10,'╝'), //3 // 10
        TURN_UR(true, false, false, true, (byte)9,'╚'), //4 // 9
        TURN_DL(false, true, true, false, (byte)6,'╗'), //5 // 6
        TURN_DR(false, true, false, true, (byte)5,'╔'), //6 // 5

        CROSS_UL(true, true, true, false, (byte)14,'╣'), //7 // 14
        CROSS_UR(true, true, false, true, (byte)13,'╠'), //8 // 13
       
        CROSS_LU(true, false, true, true, (byte)11,'╩'), //9 // 11
        CROSS_RD(false, true, true, true, (byte)7,'╦'), //10 // 7
        
        JUNKTION(true, true, true, true, (byte)15,'╬'),  //11 // 15
        
        DEAD_L(false, false, true, false, (byte)2,'┤'), //9 // 2
        DEAD_R(false, false, false, true, (byte)1,'├'), //10 //1
        
        DEAD_U(true, false, false, false, (byte)8,'┴'), //9 // 8
        DEAD_D(false, true, false, false, (byte)4,'┬'); //10 // 4
        
        public final boolean up;
        public final boolean down;
        public final boolean left;
        public final boolean right;
        public final byte id;
        public final char sign;
        
        Type(boolean up, boolean down, boolean left, boolean right, byte id, char sign) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.id = id;
            this.sign = sign;
        }
        
        public static Type getTypeById (byte id)
        {
            for (Type t : Type.values())
            {
                if (t.id == id)
                    return t;
            }
            return null;
        }
        
        public static Type getTypeByDirections (boolean mask[])
        {
            for (Type t : Type.values())
            {
                if (t.fits (mask)) return t;
            }
            return null;
        }

        private boolean fits(boolean mask[]) {
            return (this.up == mask[0] && 
                    this.down == mask[1] && 
                    this.left == mask[2] && 
                    this.right == mask[3]);
        }
        
        public void fillMask (boolean mask[])
        {
            mask[0] = this.up;
            mask[1] = this.down;
            mask[2] = this.left;
            mask[3] = this.right;
        }
        
        public char getSign ()
        {
            return this.sign;
        }

        public byte getId()
        {
            return id;
        }

        public boolean isUp()
        {
            return up;
        }

        public boolean isDown()
        {
            return down;
        }

        public boolean isLeft()
        {
            return left;
        }

        public boolean isRight()
        {
            return right;
        }
    };     

}
