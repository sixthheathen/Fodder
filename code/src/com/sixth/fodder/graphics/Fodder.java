/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.sixth.fodder.core.RoadGenerator;
import com.sixth.fodder.core.cell.Cell;
import com.sixth.fodder.graphics.screens.GameScreen;

/**
 *
 * @author sixth
 */
public class Fodder extends Game
{
    private static Fodder game;
    
    private OrthographicCamera camera;
    
    public Fodder()
    {
        game = this;
    }

    @Override
    public void create() 
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 
                          RoadGenerator.getNumOfCells() * Cell.getSizeInPix(), 
                          RoadGenerator.getNumOfCells() * Cell.getSizeInPix());
        camera.update();
        
        this.setScreen(new GameScreen());
    }

    @Override
    public void render() 
    {
        super.render();
    }
    
    @Override
    public void dispose() 
    {
        super.dispose();
    }
    
    public static Stage getStage()
    {
        final Stage stage;
        final ScalingViewport view;

        view = new ScalingViewport(
          Scaling.fit,
          RoadGenerator.getNumOfCells() * Cell.getSizeInPix(),
          RoadGenerator.getNumOfCells() * Cell.getSizeInPix(),
          game.camera
        );
        
        stage = new Stage(view);
        stage.getBatch().setProjectionMatrix(game.camera.combined);
        
        return stage;
    }
}
