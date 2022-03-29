package com.game.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    public static void draw(SpriteBatch batch, Texture texture, float x, float y){
        batch.begin();
        batch.draw(texture, x, y);
        batch.end();
    }

}
