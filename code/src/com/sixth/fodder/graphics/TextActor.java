/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author sixth
 */
public class TextActor extends Actor
{
        private BitmapFont font;
        private String text;

        public TextActor(BitmapFont font, String text) {
            this.text = text;
            this.font = font;

            font.setColor(Color.RED);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            font.draw(batch, text, 0, 0);
        }
    }
