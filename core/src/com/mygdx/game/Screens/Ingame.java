package com.mygdx.game.Screens;
import Boxes.FuelBar;
import Boxes.Tanks;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;


public class Ingame implements Screen {
    ArrayList<Bullet> bulletManager=new ArrayList<Bullet>();
    int bulletspeed=20;
    Vector2 tanklocation=new Vector2(0,0);
    Vector2 cursorlocation=new Vector2(0,0);
    Texture bullettexture;
    //Texture bullettexture1;
    private MyGdxGame game;
    public OrthographicCamera camera;
    private Viewport gamePort;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TrajectoryActor tr;
    private OrthogonalTiledMapRenderer renderer;

    private World world;

    private Box2DDebugRenderer b2dr;

    private Tanks tank;
    private Tanks tank2;
    private Texture photo;
    private Stage stage;
    public FuelBar healthbar;
    public FuelBar healthbar2;

    private Texture player1;

    public SpriteBatch batch;
    private Texture img;
    private Texture backGround_Image;
   // public OrthographicCamera camera;
    private TextButton Select_Tank;
    private Label heading;
    private Skin mySkin;
   // private Stage stage;
    private BitmapFont white, black;
   // private TextureAtlas atlas;
    private Table table;
    private TextButton buttonPlay, buttonExit,next_button,previous_button;
    private Texture texture, pausePrompt;
    float health=1,health1=1;
    Texture healthbar1,healthbar3;
    public Ingame(MyGdxGame game){
        stage = new Stage();
        photo = new Texture("tnk.png");
        bullettexture = new Texture("bullet1.png");
        //bullettexture1 = new Texture("bullet2.png");
        this.game = game;
        camera = new OrthographicCamera();
        gamePort = new FitViewport(1920, 1080,camera);
        mapLoader = new TmxMapLoader();

        healthbar = new FuelBar(300,50);
        healthbar.setPosition(100,100);

        healthbar2 = new FuelBar(300,50);
        healthbar2.setPosition(1920 - 400, 100);

        map = mapLoader.load("Map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        stage.addActor(healthbar);
        stage.addActor(healthbar2);

        healthbar1=new Texture("dot1.jpeg");
        healthbar3=new Texture("dot1.jpeg");

        map = mapLoader.load("Map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        camera.position.set(gamePort.getScreenWidth()/2, gamePort.getScreenHeight()/2, 0);
//        camera.setToOrtho(false, gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2);

        world = new World(new Vector2(0, -1000f), true);
        tank = new Tanks(world,this );
        tank2=new Tanks(world,this);
        Controller cr = new Controller();
        tr = new TrajectoryActor(cr,-0.4f);
        tr.setHeight(10f);
        tr.setWidth(10f);
//        tr.setBounds(10f, 10f, 10f, 10f);
        stage.addActor(tr);
//        player = new Tanks(world);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth()/2 , rect.getY() + rect.getHeight()/2 );
            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2, rect.getHeight() / 2);
            fdef.shape =  shape;
            body.createFixture(fdef);

        }




        batch = new SpriteBatch();
        mySkin = new Skin(Gdx.files.internal("freezing/skin/freezing-ui.json"));
        Select_Tank = new TextButton("Pause", mySkin, "default");
        Select_Tank.setBounds(70, 800, 350, 65);

//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 1200, 600);
//        backGround_Image = new Texture(Gdx.files.internal("Vict_1.jpeg"));
        stage.addActor(Select_Tank);


        Gdx.input.setInputProcessor(stage);
    }
    public Texture getPhoto(){
        return photo;
    }

    @Override
    public void show() {

    }
    public void handleInput(float delta){
        if(healthbar2.getValue()>0) {
            if (Gdx.input.isKeyPressed(Input.Keys.L)) {
                tank.b2body.applyLinearImpulse(new Vector2(40f, 0f), tank.b2body.getWorldCenter(), true);
                healthbar2.setValue(healthbar2.getValue() - 0.02f);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.K)) {
                tank.b2body.applyLinearImpulse(new Vector2(-40f, 0), tank.b2body.getWorldCenter(), true);
                healthbar2.setValue(healthbar2.getValue() - 0.02f);
            }
        }
            //tank2
        if(healthbar.getValue()>0) {
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                tank2.b2body.applyLinearImpulse(new Vector2(40f, 0f), tank.b2body.getWorldCenter(), true);
                healthbar.setValue(healthbar.getValue() - 0.02f);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                tank2.b2body.applyLinearImpulse(new Vector2(-40f, 0), tank.b2body.getWorldCenter(), true);
                healthbar.setValue(healthbar.getValue() - 0.02f);
            }
        }
        if(healthbar.getValue() == 0 || healthbar2.getValue() == 0){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
                //refill health
                healthbar.setValue(100);
                healthbar2.setValue(100);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            Controller.angle = Controller.angle + 1f;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            Controller.angle = Controller.angle - 1f;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.X)){
            Controller.pow = Controller.pow + 1f;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Z)){
            Controller.pow = Controller.pow - 1f;
        }

//        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
//            Bullet myBullet=new Bullet(tank.getX(),tank.getY(),new Vector2(0,bulletspeed));
//            bulletManager.add(myBullet);
//
//        }
//        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
//            Bullet myBullet=new Bullet(tank.getX(),tank.getY(),new Vector2(0,-bulletspeed));
//            bulletManager.add(myBullet);
//
//        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
            Bullet myBullet=new Bullet(tank2.getX(),tank2.getY(),new Vector2(-bulletspeed,0));
            bulletManager.add(myBullet);

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.V)){
            Bullet myBullet=new Bullet(tank2.getX(),tank2.getY(),new Vector2(bulletspeed,0));
            bulletManager.add(myBullet);
        }

//        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
//            Bullet myBullet=new Bullet(tank.getX(),tank.getY(),new Vector2(0,bulletspeed));
//            bulletManager.add(myBullet);
//
//            }
//        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
//            Bullet myBullet=new Bullet(tank.getX(),tank.getY(),new Vector2(0,-bulletspeed));
//            bulletManager.add(myBullet);
//            }
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            Bullet myBullet=new Bullet(tank.getX(),tank.getY(),new Vector2(-bulletspeed,0));
            bulletManager.add(myBullet);

            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
            {
                Bullet myBullet=new Bullet(tank.getX(),tank.getY(),new Vector2(bulletspeed,0));
                bulletManager.add(myBullet);
            }
        if (health>0) {
            if (Gdx.input.isKeyPressed(Input.Keys.V) ){
                health-=0.01f;
            }
            if (health<=0){
                health=0;
            }
        }
        if (health1>0) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ){
                health1-=0.01f;
            }
            if (health1<=0){
                health1=0;

            }
        }



    }

    public void update(float delta){
        handleInput(delta);
        tank.update(delta);
        tank2.update(delta);
        world.step(1/60f, 6, 2);
//        camera.position.x = tank.b2body.getPosition().x;
        camera.update();

        renderer.setView(camera);
    }
    @Override
    public void render(float delta) {
        tr.setX(tank.b2body.getPosition().x);
        tr.setY(tank.b2body.getPosition().y);
        tr.setX(tank2.b2body.getPosition().x);
        tr.setY(tank2.b2body.getPosition().y);
//        System.out.println("yes");
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        game.batch.setProjectionMatrix();

        renderer.render();
        b2dr.render(world, camera.combined);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        tank.draw(game.batch);
        tank2.draw(game.batch);

        game.batch.setColor(Color.RED);
        game.batch.draw(healthbar1,500, 1000,100*health1,50);
        game.batch.draw(healthbar3,1100, 1000,100*health,50);
        game.batch.setColor(Color.WHITE);


//        tr.draw(game.batch,1);
        game.batch.end();
        stage.draw();
        stage.act(delta);
        game.batch.begin();
        int counter=0;
        while(counter<bulletManager.size()){
            Bullet currentBullet=bulletManager.get(counter);
            currentBullet.Update();
            game.batch.draw(bullettexture,currentBullet.bulletlocation.x,currentBullet.bulletlocation.y);
            //game.batch.draw(bullettexture1,currentBullet.bulletlocation.x,currentBullet.bulletlocation.y);

            counter++;

        }
        game.batch.end();
        Select_Tank.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.dispose();
                game.setScreen(new pauseScreen(game));
            }
        });

        Select_Tank.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.dispose();
//                pausePrompt = new Texture(Gdx.files.internal("ign menu.png")) ;
//                Select_Tank.addListener(new ClickListener(){
//                    @Override
//                    public void clicked(InputEvent event, float x, float y) {
////                        flag = true;
//                        Gdx.input.setInputProcessor(stage);
//                    }
//                });
//                if (Gdx.input.getX() > 705 && Gdx.input.getX() < 1237 && Gdx.input.getY() > 395 && Gdx.input.getY() < 601) {
//                    if (Gdx.input.justTouched()) {
//                        dispose();
//                        game.setScreen(new Ingame(game));
//                    }
//                }
//                if (Gdx.input.getX() > 705 && Gdx.input.getX() < 1237 && Gdx.input.getY() > 656 && Gdx.input.getY() < 735) {
//                    if (Gdx.input.justTouched()) {
//                        dispose();
//                        game.setScreen(new MainMenu(game));
//                    }
//                }
//                game.setScreen(new pauseScreen(game));
            }
        });

    }

    @Override
    public void resize(int width, int height) {
        // use true here to center the camera
        gamePort.update(width,height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

