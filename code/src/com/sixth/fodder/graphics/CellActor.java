/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sixth.fodder.graphics.atlasses.*;

/**
 *
 * @author sixth
 */

public class CellActor extends Actor
{
    // TODO: make enums for atlases like for roadsAtlas
    private static final TextureAtlas backCellsAtlas = new TextureAtlas(Gdx.files.internal("assets/backCells/backCells.pack"));
    private static final TextureAtlas buildingsAtlas = new TextureAtlas(Gdx.files.internal("assets/buildings/buildings.pack"));
    private static final TextureAtlas roadsAtlas = new TextureAtlas(Gdx.files.internal("assets/roads/roads.pack"));

    private TextureRegion texture;
    
    public CellActor()
    {
        setTexture("voidCell");
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
    
    // choose the cell's texture by it's name
    
    public void setTexture(String name) 
    {
        for (BackCell b : BackCell.values())
            if (name.equals(b.getName()))
                this.texture = b.getTexture();
        for (Building b : Building.values())
            if (name.equals(b.getName()))
                this.texture = b.getTexture();
        for (Road r : Road.values())
            if (name.equals(r.getName()))
                this.texture = r.getTexture();
    }
    
    // accessors for atlasses to dispose
    
    public static TextureAtlas getBackCellsAtlas() 
    {
        return backCellsAtlas;
    }

    public static TextureAtlas getBuildingsAtlas() 
    {
        return buildingsAtlas;
    }

    public static TextureAtlas getRoadsAtlas() 
    {
        return roadsAtlas;
    }
}
