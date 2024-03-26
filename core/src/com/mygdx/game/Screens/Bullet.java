package com.mygdx.game.Screens;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
    public Vector2 bulletlocation = new Vector2(0,0);
    public Vector2 bulletvelocity = new Vector2(0,0);
    public Bullet(float x,float y,Vector2 sentvelocity)
    {
        bulletlocation=new Vector2(x,y);
        bulletvelocity=new Vector2(sentvelocity.x,sentvelocity.y);
    }
    public void Update()
    {
        bulletlocation.x += bulletvelocity.x;
        bulletlocation.y += bulletvelocity.y;
    }
}
