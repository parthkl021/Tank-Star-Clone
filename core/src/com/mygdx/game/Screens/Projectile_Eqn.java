package com.mygdx.game.Screens;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

class Projectile_Eqn{
    public float g;
    public Vector2 v0 = new Vector2();
    public Vector2 p0 = new Vector2();

    public float getX(float t){
        return p0.x + v0.x * t;
    }
    public float getY(float t){
        return p0.y + v0.y * t + 0.5f * g * t * t;
    }
}




