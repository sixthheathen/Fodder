/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sixth.fodder.core.RoadGenerator;
import com.sixth.fodder.core.cell.Cell;
import com.sixth.fodder.graphics.CellActor;
import com.sixth.fodder.graphics.Fodder;
import static demogen.DemoGen.generate;

/**
 *
 * @author sixth
 */
public class GameScreen implements Screen
{
        private Cell[][] cells;
        
        private Stage stage;
	
	public GameScreen() 
        {
            this.stage = Fodder.getStage();
            
            cells = new RoadGenerator().getCells();
                
            for (int i = 0; i < RoadGenerator.getMapHeight(); ++i)
                for (int j = 0; j < RoadGenerator.getMapWidth(); ++j)
                    stage.addActor(cells[i][j].getActor());    
        }
        
	@Override
	public void render(float delta) 
        {
//                camera.update();
//                game.batch.setProjectionMatrix(camera.combined);
                
//                stage.draw();
//                stage.act(Gdx.graphics.getDeltaTime());
                
            //----------------------------------------------------------- 
                
            Gdx.gl.glClearColor(0.8f, 0.7f, 0.5f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            
            stage.act();
            stage.draw();
                
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
	public void dispose() 
        {
            stage.dispose();
            CellActor.getBackCellsAtlas().dispose();
            CellActor.getBuildingsAtlas().dispose();
            CellActor.getRoadsAtlas().dispose();
	}
}
