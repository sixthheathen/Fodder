/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics.atlasses;

import com.sixth.fodder.graphics.*;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author sixth
 */
public enum People
{
    manL ("ManLeftLeg"),
    manR ("ManRightLeg"),
    womanL ("WomanLeftLeg"),
    womanR ("WomanRightLeg");
    
    private final TextureRegion texture;

    People (String name)
    {
        texture = CellActor.getPeopleAtlas().findRegion(name);
    }

    public TextureRegion getTexture() 
    {
        return texture;
    } 
}
