/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author sixth
 */
public enum RoadTexture 
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
    
    // FIXME: textureAtlas should be static, but it's not allowed. Move outside the enum?
    private final TextureAtlas roadsAtlas = new TextureAtlas(Gdx.files.internal("assets/roads/roads.pack"));
    private final TextureRegion texture;
    private final String name;

    RoadTexture (String name)
    {
        this.name = name;
        texture = roadsAtlas.findRegion(name);
    }

    public TextureRegion getTexture() 
    {
        return texture;
    }
    
    // FIXME: If moving atlas outside the enum, this will move to the cell actor (better)
    public TextureAtlas getRoadsAtlas() 
    {
        return roadsAtlas;
    }
}
