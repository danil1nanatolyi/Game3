package com.game.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Character characterLeft;
    Character characterRight;


    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        characterLeft = new Character("FireKnight", 50, 30);
        characterRight = new Character("WaterPrincess", 200, 30);
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);

        //------------------------------ ИГРОК СЛЕВА ---------------------------------
        //Влево
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            Controller.draw(batch, characterLeft.runTextures.get(0), characterLeft.personRectangle.x, characterLeft.personRectangle.y);
            characterLeft.personRectangle.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        //Вправо
        else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            Controller.draw(batch, characterLeft.runTextures.get(0), characterLeft.personRectangle.x, characterLeft.personRectangle.y);
            characterLeft.personRectangle.x += 200 * Gdx.graphics.getDeltaTime();
        }
        //Левый ctrl
        else if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            Controller.draw(batch, characterLeft.attackTextures.get(5), characterLeft.personRectangle.x, characterLeft.personRectangle.y);
        } else {
            Controller.draw(batch, characterLeft.idleTextures.get(0), characterLeft.personRectangle.x, characterLeft.personRectangle.y);
        }

        if (characterLeft.personRectangle.x < 0){
            characterLeft.personRectangle.x = 0;
        }
        if (characterLeft.personRectangle.x > characterRight.personRectangle.x){
            characterLeft.personRectangle.x = characterRight.personRectangle.x;
        }

        //------------------------- ИГРОК СПРАВА ---------------------------------
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            Controller.draw(batch, characterRight.runTextures.get(0), characterRight.personRectangle.x, characterRight.personRectangle.y);
            characterRight.personRectangle.x -= 200 * Gdx.graphics.getDeltaTime();
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            Controller.draw(batch, characterRight.runTextures.get(0), characterRight.personRectangle.x, characterRight.personRectangle.y);
            characterRight.personRectangle.x += 200 * Gdx.graphics.getDeltaTime();
        } else if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT)) {
            Controller.draw(batch, characterRight.attackTextures.get(4), characterRight.personRectangle.x, characterRight.personRectangle.y);
        } else {
            Controller.draw(batch, characterRight.idleTextures.get(0), characterRight.personRectangle.x, characterRight.personRectangle.y);
        }

//        if (characterRight.personRectangle.x > Gdx.graphics.getWidth()){
//            characterRight.personRectangle.x = Gdx.graphics.getWidth();
//        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
