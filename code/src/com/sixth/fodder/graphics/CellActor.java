
package com.sixth.fodder.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author sixth
 */

public class CellActor extends Actor
{
    private static final TextureAtlas backCellsAtlas = new TextureAtlas(Gdx.files.internal("assets/backCells/backCells.pack"));
    private static final TextureAtlas buildingsAtlas = new TextureAtlas(Gdx.files.internal("assets/buildings/buildings.pack"));
    private static final TextureAtlas roadsAtlas = new TextureAtlas(Gdx.files.internal("assets/roads/roads.pack"));

    private TextureRegion texture;
    
    @Override
    public void draw(Batch batch, float parentAlpha) 
    {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
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
    
    

    public void setTexture(TextureRegion texture)
    {
        this.texture = texture;
    }                                 
}
