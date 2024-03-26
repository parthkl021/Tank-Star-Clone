package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

public class MainMenu implements Screen {
    MyGdxGame game;
    private Texture textureBackground;
    private ImageButton button;
    private Stage stage1;
    private Skin skin;
    private TextButton textButton1;
    private TextButton textButton2;
    private  TextButton textButton3;
    private  TextButton textButton4;

    MainMenu(MyGdxGame game){
        stage1 = new Stage();
        this.game = game;
        textureBackground = new Texture(Gdx.files.internal("menu _no.png"));
        skin = new Skin(Gdx.files.internal("freezing/skin/freezing-ui.json"));
        textButton1 = new TextButton("Resume",skin,"default");
        textButton1.setPosition(1430,800);
        textButton1.setSize(400, 150);

        textButton2 = new TextButton("V/S Friend",skin,"default");
        textButton2.setPosition(1430,600);
        textButton2.setSize(400, 150);

        textButton3 = new TextButton("Saved Games",skin,"default");
        textButton3.setPosition(1430,400);
        textButton3.setSize(400, 150);

        textButton4 = new TextButton("Quit Game",skin,"default");
        textButton4.setPosition(1430,200);
        textButton4.setSize(400, 150);

        stage1.addActor(textButton1);
        stage1.addActor(textButton2);
        stage1.addActor(textButton3);
        stage1.addActor(textButton4);

        Gdx.input.setInputProcessor(stage1);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(textureBackground, 0, 0);
        game.batch.end();
        stage1.draw();

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
                game.setScreen(new Player1(game));
            }
        });
        textButton3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new SavedGame(game));
            }
        });
        textButton4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new QuitGame(game));
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
        stage1.dispose();
    }
}
