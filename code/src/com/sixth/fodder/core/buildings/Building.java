package com.sixth.fodder.core.buildings;

//import java.util.Random;

import com.sixth.fodder.core.man.Man;
import java.util.Random;


/**
 *
 * @author sixth
 */
public abstract class Building 
{
    private static final Random random = new Random();
    private final String name;
    private long openingHours;
    private long closingHours;
    private static int nextId = 0;
    private final int id;
    private final byte[] coords = new byte[2];
    
    public Building (String name)
    {
        this.name = name;
        this.openingHours = (random.nextInt(3) + 7) * 60 * 60; // work starts between 7 AM and 10 AM
        this.closingHours = (random.nextInt(4) + 20) * 60 * 60; // work finishes between 8 PM and midnight
        this.id = nextId;
        nextId++;
    }
    
    public static int getNextId()
    {
        return nextId;
    }
    
    public abstract Boolean acceptRequest(Man man);

    public String getName() 
    {
        return name;
    }
    
    public Boolean isOpen (long time)
    {
        if (openingHours == closingHours)
            return true;
        else if (time < closingHours || time > openingHours)
            return true;
        return false;
    }
}
