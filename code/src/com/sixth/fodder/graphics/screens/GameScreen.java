/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sixth.fodder.core.buildings.Building;
import com.sixth.fodder.graphics.CellActor;
import com.sixth.fodder.graphics.Fodder;

/**
 *
 * @author sixth
 */
public class GameScreen implements Screen
{
        final Fodder game;
        private final Stage stage;
        private final OrthographicCamera camera;
        
        private final Building[] buildings;
//        private final RoadGenerator roadGen;
//        private final Cell[][] cells;
	
	public GameScreen(final Fodder game) 
        {
                this.game = game;  
                camera = new OrthographicCamera(RoadGenerator.getNumOfCells() * Cell.getSizeInPix(), 
                        
                
                stage = new Stage(new ScreenViewport, game.batch);
                
                buildings = new Building[3];
                for (int i = 0; i < 3; i++)
                {
                    buildings[i] = new Building();
                }

//                roadGen = new RoadGenerator();
//                roadGen.placeBuildings(buildings);
//                
//                cells = RoadGenerator.getCells();
                
                for (int i = 0; i < RoadGenerator.getNumOfCells(); ++i)
                    for (int j = 0; j < RoadGenerator.getNumOfCells(); ++j)
                        stage.addActor(cells[i][j].getActor());
        }
        
	@Override
	public void render(float delta) 
        {
//                camera.update();
//                game.batch.setProjectionMatrix(camera.combined);
                
                stage.draw();
                stage.act(Gdx.graphics.getDeltaTime());
                
                if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
                {
                    Gdx.app.exit();
                    dispose();
                }
	}

	@Override
	public void resize(int width, int height) 
        {
            stage.getViewport().update(width, height, true);
        }

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {
		game.dispose();
                stage.dispose();
                CellActor.getBackCellsAtlas().dispose();
                CellActor.getBuildingsAtlas().dispose();
                CellActor.getRoadsAtlas().dispose();
	}
}
