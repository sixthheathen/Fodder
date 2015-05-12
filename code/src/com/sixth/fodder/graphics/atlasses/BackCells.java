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
public enum BackCells 
{
    voidCell ("voidCell");
    
    private final TextureRegion texture;

    BackCells (String name)
    {
        texture = CellActor.getBackCellsAtlas().findRegion(name);
    }

    public TextureRegion getTexture() 
    {
        return texture;
    }
}
