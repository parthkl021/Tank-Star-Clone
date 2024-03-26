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
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.MyGdxGame;

public class SavedGame implements Screen {
    MyGdxGame game;
    private Stage stage3;

    private Texture textureBackground1;
//    private Skin skin;
//    private TextButton textButton1;
//    private TextButton textButton2;
//    private  TextButton textButton3;
    private ImageButton button;
    SavedGame(MyGdxGame game){
        stage3 = new Stage();
        this.game = game;
        textureBackground1 = new Texture(Gdx.files.internal("save (1).png"));
        button = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("ex.png"))));
        button.setSize(250,300);
        button.setPosition(1550, 800);
        stage3.addActor(button);
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
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new MainMenu(game));
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
