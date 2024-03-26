package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

public class Player2 implements Screen {
    MyGdxGame game;
    private Stage stage3;
    private Texture textureBackground1;
    private Skin skin;
    private TextButton textButton1;
    private TextButton textButton2;
    private  TextButton textButton3;

    Player2(MyGdxGame game){
        stage3 = new Stage();
        this.game = game;
        textureBackground1 = new Texture(Gdx.files.internal("l2 (1).png"));
        skin = new Skin(Gdx.files.internal("freezing/skin/freezing-ui.json"));
        textButton1 = new TextButton("Tank1",skin,"default");
        textButton1.setPosition(140,125);
        textButton1.setSize(400, 150);

        textButton2 = new TextButton("Tank2",skin,"default");
        textButton2.setPosition(770,125);
        textButton2.setSize(400, 150);

        textButton3 = new TextButton("Tank3",skin,"default");
        textButton3.setPosition(1430,125);
        textButton3.setSize(400, 150);

        stage3.addActor(textButton1);
        stage3.addActor(textButton2);
        stage3.addActor(textButton3);

        Gdx.input.setInputProcessor(stage3);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(textureBackground1, 0, 0);
        game.batch.end();
        stage3.draw();
        textButton1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new Ingame(game));
            }
        });
        textButton2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new Ingame(game));
            }
        });
        textButton3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new Ingame(game));
            }
        });
    }

    @Override
    public void resize(int width, int height) {

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
        stage3.dispose();
    }
}
