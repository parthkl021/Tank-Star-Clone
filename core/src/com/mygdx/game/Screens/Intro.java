package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.MyGdxGame;
import sun.jvm.hotspot.gc.shared.Space;

public class Intro implements Screen {
    MyGdxGame game;
    private Texture textureBackground;
    private ImageButton button;
    private Stage stage;
    private Skin skin;
    private TextButton textButton;
    public Intro(MyGdxGame game){
        this.game = game;
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("freezing/skin/freezing-ui.json"));
//        textButton = new TextButton("Resume",skin,"default");
//        textButton.setPosition(100,100);
//        textButton.setSize(400, 150);
        textureBackground = new Texture(Gdx.files.internal("My project-1.png"));
//        button = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("img.png"))));
//        button.setPosition(200, 200);
//        stage.addActor(button);
//        stage.addActor(textButton);
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(textureBackground, 0, 0);
        stage.draw();

        game.batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            dispose();
//            int a = 3;
            Music menuMusic = null;
            menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Heat_Waves.ogg"));
//            System.out.println(menuMusic.isPlaying());

            menuMusic.play();
            menuMusic.setLooping(true);
            game.setScreen(new MainMenu(game));
        }
//        textButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                dispose();
//                game.setScreen(new MainMenu(game));
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
        stage.dispose();
    }
}
