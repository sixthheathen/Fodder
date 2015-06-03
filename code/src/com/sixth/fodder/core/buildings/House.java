package com.sixth.fodder.core.buildings;

import com.sixth.fodder.core.man.Man;

/**
 *
 * @author sixth
 */
public class House extends Building
{
    private final int capacity = 100;
    private int[] occupantsId;

    public House() 
    {
        super("house");
        occupantsId = new int[capacity];
//        for (int i = 0; i < capacity; i++)
//        {
//            occupantsId[i] = i * 3 + super.id;
//        }
    }

    @Override
    public Boolean acceptRequest(Man man) 
    {
        for (int i = 0; i < occupantsId.length; ++i)
            if (occupantsId[i] == man.getId())
                return true;
        return false;
    }
}
