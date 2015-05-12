/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

/**
 *
 * @author sixth
 */
public class Direction 
{
//    private final int id;
    private Boolean exists;
    private Cell cell;
    
    Direction (int id, Boolean exists)
    {
//        this.id = id;
        this.exists = exists;
        this.cell = null;
    }

//    public int getId() 
//    {
//        return id;
//    }

    public Boolean exists() 
    {
        return exists;
    }

    public void exists(Boolean exists) 
    {
        this.exists = exists;
    }    

    public void setCell(Cell cell) 
    {
        this.cell = cell;
    }
}
