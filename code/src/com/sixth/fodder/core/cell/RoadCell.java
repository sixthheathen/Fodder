/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.graphics.atlasses.Road;

/**
 *
 * @author sixth
 */
public class RoadCell extends Cell

{
    RoadCell (int x, int y)
    {
        super(x, y);
    }
    
    public void setTexture()
    {
        for (Road r : Road.values())
            if (name.equals(r.getName()))
                super.getActor().setTexture(r.getTexture());
    }
}
