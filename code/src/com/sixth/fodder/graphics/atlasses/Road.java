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
public enum Road 
{
    uRoad ("uRoad"),
    dRoad ("dRoad"),
    lRoad ("lRoad"),
    rRoad ("rRoad"),
    udRoad ("udRoad"),
    ulRoad ("ulRoad"),
    urRoad ("urRoad"),
    dlRoad ("dlRoad"),
    drRoad ("drRoad"),
    lrRoad ("lrRoad"),
    udlRoad ("udlRoad"),
    udrRoad ("udrRoad"),
    ulrRoad ("ulrRoad"),
    dlrRoad ("dlrRoad"),
    udlrRoad ("udlrRoad");
    
    private final TextureRegion texture;

    Road (String name)
    {
        texture = CellActor.getRoadsAtlas().findRegion(name);
    }

    public TextureRegion getTexture() 
    {
        return texture;
    }
}
