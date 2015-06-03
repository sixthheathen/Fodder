package com.sixth.fodder.core.man;

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
public class Man
{
    private static final Random random = new Random();
    private final String name;
    private final String surname;
//    private final Occupation occupation;
//    private String place; // current or next place
//    private Boolean onTheWay; // current state is on the road
//    private int cash;
    private final int id;
    private static int nextId;
    private final boolean male;
    private final byte[] houseCoord = new byte[2];
//    private final int houseId;
    
    public Man ()
    {
        this.male = random.nextBoolean();
        if (male)
            this.name = Names.getMaleName();
        else
            this.name = Names.getFemaleName();
        this.surname = Names.getSurname();
        this.id = nextId;
        nextId++;
//        this.occupation = new Occupation();
//        this.cash = occupation.getSalary();
//        this.houseId = this.id % 3;
    }
    
    public void printData()
    {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        if (male)
             System.out.println("Gender: male");
        else
             System.out.println("Gender: female");
//        System.out.println("Job: " + occupation.getJob());
//        System.out.println("Works from " + occupation.getTimeFrom() / (60 * 60) + 
//                " till " + occupation.getTimeTill() / (60 * 60));
//        System.out.println("Salary: " + occupation.getSalary());
//        System.out.println("houseId: " + houseId + "\n");
    }

    public int getId() 
    {
        return id;
    }
}