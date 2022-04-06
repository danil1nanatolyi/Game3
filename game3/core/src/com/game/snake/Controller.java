package com.game.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Controller {
    public static void draw(SpriteBatch batch, Animation animation, Character character, float time){
        TextureRegion currentFrame = (TextureRegion) animation.getKeyFrame(time, true);
        batch.begin();
        batch.draw(
                currentFrame,
                character.personRectangle.x,
                character.personRectangle.y,
                0, 0,
                300, 250,
                1f, 1f,
                0
        );
        batch.end();
    }

    public static void drawHP(int x, int y, float hp){
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.setColor(Color.RED);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(x, y, hp * 2.5f, 8);
        shapeRenderer.end();
    }

    public static Animation createAnimation(String path, int cols, int rows){
        int frames = cols*rows;
        Texture walkSheet = new Texture(Gdx.files.internal(path)); // #9
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/cols, walkSheet.getHeight()/rows); // #10
        TextureRegion[] walkFrames = new TextureRegion[frames];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        Animation animation = new Animation(1f/frames, walkFrames); // #11
        return animation;
    }

    public static void setControl(SpriteBatch batch, Character character, float time){
        if (Gdx.input.isKeyPressed(character.buttonLeft)) {
            Controller.draw(batch, character.runLeftAnimation, character, time);
            character.personRectangle.x -= 100 * Gdx.graphics.getDeltaTime();
        }
        else if (Gdx.input.isKeyPressed(character.buttonRight)) {
            Controller.draw(batch, character.runRightAnimation, character, time);
            character.personRectangle.x += 100 * Gdx.graphics.getDeltaTime();

        }
        else if (Gdx.input.isKeyPressed(character.buttonAttack)) {
            playMusicOnce("sound.mp3");
            Controller.draw(batch, character.attackAnimation, character, time);
        } else {
            Controller.draw(batch, character.idleAnimation, character, time);
        }
    }

    private static void playMusicOnce(String sound){
        Music udar = Gdx.audio.newMusic(Gdx.files.internal(sound));
        udar.setVolume(0.5f);
        udar.play();
    }

}
