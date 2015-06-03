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
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sixth.fodder.core.RoadGenerator;
import com.sixth.fodder.core.cell.*;
import com.sixth.fodder.graphics.CellActor;
import com.sixth.fodder.graphics.Fodder;

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
                    if (!(cells[i][j] instanceof BackCell))
                        stage.addActor(cells[i][j].getActor());
            
//            System.out.println(stage.getViewport().getCamera().position.x + " " + // в 2 раза меньше чем ниже
//                    stage.getViewport().getCamera().position.y);
//            System.out.println(stage.getViewport().getScreenHeight() + " " +
//                    stage.getViewport().getScreenWidth()); // кол-во клеток на 64
        }
        
	@Override
	public void render(float delta) 
        {
//                camera.update();
//                game.batch.setProjectionMatrix(camera.combined);
                
//                stage.draw();
//                stage.act(Gdx.graphics.getDeltaTime());
                
            //----------------------------------------------------------- 
              
            handleInput();
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
            CellActor.getPeopleAtlas().dispose();
	}
        
        private void handleInput() {
            float rotationSpeed = 0.5f;
            int move = 64;
            
            if (Gdx.input.isKeyPressed(Input.Keys.A)) 
            {
                ((OrthographicCamera)(stage.getViewport().getCamera())).zoom += 0.02;
//                move = (int)((1 + 0.02)*(move));
            }
            if (Gdx.input.isKeyPressed(Input.Keys.Q)) 
            {
                ((OrthographicCamera)(stage.getViewport().getCamera())).zoom -= 0.02;
//                move = (int)((1 - 0.02)*(move));
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) 
            {
                stage.getViewport().getCamera().translate(-move, 0, 0);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) 
            {
                stage.getViewport().getCamera().translate(move, 0, 0);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) 
            {
                stage.getViewport().getCamera().translate(0, -move, 0);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) 
            {
                stage.getViewport().getCamera().translate(0, move, 0);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) 
            {
                stage.getViewport().getCamera().rotate(-rotationSpeed, 0, 0, 1);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.E)) 
            {
                stage.getViewport().getCamera().rotate(rotationSpeed, 0, 0, 1);
            }

//            ((OrthographicCamera)(stage.getViewport().getCamera())).zoom = MathUtils.clamp(((OrthographicCamera)(stage.getViewport().getCamera())).zoom, 0.1f, 100/(stage.getViewport().getCamera()).viewportWidth);
////
//        float effectiveViewportWidth = stage.getViewport().getCamera().viewportWidth * ((OrthographicCamera)(stage.getViewport().getCamera())).zoom;
//        float effectiveViewportHeight = stage.getViewport().getCamera().viewportHeight * ((OrthographicCamera)(stage.getViewport().getCamera())).zoom;
//
//        stage.getViewport().getCamera().position.x = MathUtils.clamp(stage.getViewport().getCamera().position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
//        stage.getViewport().getCamera().position.y = MathUtils.clamp(stage.getViewport().getCamera().position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
    }
}
