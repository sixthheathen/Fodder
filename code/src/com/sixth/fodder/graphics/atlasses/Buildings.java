/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics.atlasses;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sixth.fodder.graphics.CellActor;

/**
 *
 * @author sixth
 */
public enum Buildings 
{
    house ("house"),
    cafe ("cafe");
    
    private final TextureRegion texture;

    Buildings (String name)
    {
        texture = CellActor.getBuildingsAtlas().findRegion(name);
    }

    public TextureRegion getTexture() 
    {
        return texture;
    }
}
