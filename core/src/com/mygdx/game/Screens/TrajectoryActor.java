package com.mygdx.game.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
//import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TrajectoryActor extends Actor {
    private Controller control;
    private Projectile_Eqn projectile_eqn;
//    private Sprite trajectorySprite;
    private Texture dot;
    public int trajectoryPoints = 10;
    public float time_sep = 5f;

    public TrajectoryActor(Controller control, float gravity){
        this.control = control;
        this.projectile_eqn = new Projectile_Eqn();
        this.projectile_eqn.g = gravity;
    }
    @Override
    public void act(float delta){
        super.act(delta);
        projectile_eqn.v0.set(control.pow ,0f);
        projectile_eqn.v0.rotateDeg(control.angle);
    }
    @Override
    public void draw(Batch batch , float parentAlpha){
        float t = 0f;
        float width = this.getWidth();
        float height = this.getHeight();
        dot = new Texture("dot2.png");
        float time_sep = this.time_sep;
        for(int i = 0; i < trajectoryPoints; i++){
            float x = this.getX() + projectile_eqn.getX(t);
            float y = this.getY() + projectile_eqn.getY(t);
//            batch.setColor(this.color);
            batch.draw(dot, x, y, width, height);
            t += time_sep;
        }
//        public Actor hit
//        public Actor hit(float x, float y, boolean touchable){
//            return null;
//        }

    }

}
