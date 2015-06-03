package com.sixth.fodder.core.man;

import com.sixth.fodder.core.buildings.Building;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sixth
 */
public class Occupation 
{
    private final String job;
    private static final String jobs [] =
    {
        "Human Prop",
        "Professional Sleeper",
        "Cliff Diver",
        "Iceberg Mover",
        "Paint Drying Watcher",
        "Full-Time Barbecue Editor",
        "Professional Mourner",
        "Human Scarecrow",
        "Junior Lego Model-Maker",
        "Mattress Jumper",
        "Professional Ethical Hacker",
        "Pencil Sharpener",
        "Professional Snuggler",
        "Cheese Sculptor",
        "Presidential Poison Taster",
        "Golf Ball Divers",
        "Professional Cat Catcher",
        "Female Hysteria Doctor",
        "Lamplighter",
        "Resurrectionist"
    };
    private final long timeFrom;
    private final long timeTill;
    private final int salary;
    private final int id;
    
    public Occupation()
    {
        Random random = new Random();
        job = jobs[random.nextInt(jobs.length)];
        timeFrom = (random.nextInt(3) + 7) * 60 * 60; // work starts between 7 AM and 10 AM
        timeTill = (random.nextInt(3) + 17) * 60 * 60; // work finishes between 5 PM and 8 PM
        salary = random.nextInt(4000) + 1000;
        this.id = random.nextInt(Building.getNextId());
        
    }
    
    public String getJob () 
    {
        return job;
    }

    public long getTimeFrom() 
    {
        return timeFrom;
    }

    public long getTimeTill() 
    {
        return timeTill;
    }

    public int getSalary() 
    {
        return salary;
    }
}
