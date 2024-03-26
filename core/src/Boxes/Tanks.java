package Boxes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Screens.Ingame;

public class Tanks extends Sprite {
    public World world;
    public Body b2body;
    private Texture texture;
    private static int tankno ;
    public Tanks(World world, Ingame screen) {
        super(tankno == 0 ? new Texture(Gdx.files.internal("tank.png")) : new Texture(Gdx.files.internal("tnk.png")));
        if (tankno == 0) {
            this.world = world;
            defineTank();
            setBounds(0, 0, 100, 65);
            setRegion(new Texture(Gdx.files.internal("tank.png")));
        }
        else
        {
            this.world = world;
            defineTank();
            setBounds(0, 0, 100, 65);
            setRegion(new Texture(Gdx.files.internal("tnk.png")));
        }
        tankno++;
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 5);
    }

    public void defineTank(){
        BodyDef bdef = new BodyDef();
        if (tankno==1) {
            bdef.position.set(400, 450);
        }else{
            bdef.position.set(1400,500);
        }
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(4);
        fdef.shape = shape;
        fdef.restitution=0f;
        fdef.friction = 0.5f;
        b2body.createFixture(fdef);

    }
}
