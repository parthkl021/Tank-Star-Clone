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

public class pauseScreen implements Screen {
    MyGdxGame game;
    private Texture textureBackground;
    private ImageButton button;
    private Stage stage1;
    private Skin skin;
    private TextButton textButton1;
    private TextButton textButton2;
    private  TextButton textButton3;
    private  TextButton textButton4;

    pauseScreen(MyGdxGame game){
        stage1 = new Stage();
        this.game = game;
        textureBackground = new Texture(Gdx.files.internal("pause_menu.png"));
        skin = new Skin(Gdx.files.internal("freezing/skin/freezing-ui.json"));
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
        if (Gdx.input.isTouched()) {
            System.out.println("touched at " + Gdx.input.getX() + " " + Gdx.input.getY() + " " + "in tank selection screen 1");
        }
        if (Gdx.input.getX() > 705 && Gdx.input.getX() < 1237 && Gdx.input.getY() > 395 && Gdx.input.getY() < 601) {
            if (Gdx.input.justTouched()) {
                dispose();
                game.setScreen(new Ingame(game));
            }
        }
        if (Gdx.input.getX() > 705 && Gdx.input.getX() < 1237 && Gdx.input.getY() > 656 && Gdx.input.getY() < 735) {
            if (Gdx.input.justTouched()) {
                dispose();
                game.setScreen(new MainMenu(game));
            }
        }
//
//        textButton1.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                dispose();
//                game.setScreen(new Ingame(game));
//            }
//        });
//        textButton2.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                dispose();
//                game.setScreen(new Player1(game));
//            }
//        });
//        textButton3.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                dispose();
//                game.setScreen(new SavedGame(game));
//            }
//        });
//        textButton4.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                dispose();
//                game.setScreen(new QuitGame(game));
//            }
//        });

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
