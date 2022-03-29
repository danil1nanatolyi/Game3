package com.game.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class Character {
    String name = "";
    int health = 100;
    int strength = 20;
    int damage = 20;
    Rectangle personRectangle;

    ArrayList<Texture> idleTextures = new ArrayList<>();
    ArrayList<Texture> runTextures = new ArrayList<>();
    ArrayList<Texture> attackTextures = new ArrayList<>();

    Character(String name, float x, float y){
        this.name = name;

        personRectangle = new Rectangle();
        personRectangle.x = x;
        personRectangle.y = y;

        for (int i = 1; i <= 8; i++){
            Texture texture = new Texture(Gdx.files.internal(name + "/Idle/idle_" + i + ".png"));
            idleTextures.add(texture);
            texture = new Texture(Gdx.files.internal(name + "/Run/run_" + i + ".png"));
            runTextures.add(texture);
            texture = new Texture(Gdx.files.internal(name + "/Attack/atk_" + i + ".png"));
            attackTextures.add(texture);
        }
    }

}
