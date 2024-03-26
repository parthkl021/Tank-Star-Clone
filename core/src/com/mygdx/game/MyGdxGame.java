package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Screens.Bullet;
import com.mygdx.game.Screens.Controller;
import com.mygdx.game.Screens.Intro;

import java.util.ArrayList;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
//	ArrayList<Bullet>bulletManager=new ArrayList<Bullet>();
//
//	Vector2 tanklocation=new Vector2(0,0);
//	Vector2 cursorlocation=new Vector2(0,0);
	//Bullet testbullet = new Bullet(tanklocation,new Vector2(10,0));
//	Texture img;
//	Sprite sprite;
//	Texture bullettexture;
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new Intro(this));
//		bullettexture = new Texture("bullet.png");

	}
//	public void handle(){
//
//		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
//			Bullet myBullet=new Bullet(tanklocation,new Vector2(0,20));
//			bulletManager.add(myBullet);
//
//		}
//	}
	@Override
	public void render () {
		super.render();
		//testbullet.update();
//		int counter=0;
//		while(counter<bulletManager.size()){
//			Bullet currentBullet=bulletManager.get(counter);
//			currentBullet.update();
//			batch.draw(bullettexture,currentBullet.bulletlocation.x,currentBullet.bulletlocation.y);
//			counter++;

		}

		//batch.draw(bullettexture,testbullet.bulletlocation.x,testbullet.bulletlocation.y);

	}
//	public class Menu implements Screen{
//		 public Texture texture;
//		 public Skin skin;
//		 public Stage  stage;
//		 public Menu(){
//			 texture = new Texture(Gdx.files.internal("try2.jpeg"));
//			 skin = new Skin(Gdx.files.internal("skin.json"));
//			 stage = new Stage();
//			 Label mm = new Label("hi", skin, "default");
//			 mm.setSize(100, 100);
//			 mm.setPosition(0,0);
//
//		 }
//
//		@Override
//		public void show() {
//
//		}
//
//		@Override
//		public void render(float delta) {
//
//		}
//
//		@Override
//		public void resize(int width, int height) {
//
//		}
//
//		@Override
//		public void pause() {
//
//		}
//
//		@Override
//		public void resume() {
//
//		}
//
//		@Override
//		public void hide() {
//
//		}
//
//		@Override
//		public void dispose() {
//
//		}
//	}

//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
	//if enter key is pressed open another image


//	@Override
//	public void OrthographicCamera() {
//		// TODO Auto-generated method stub
//		OrthographicCamera resize = new OrthographicCamera(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
//		resize.translate(Gdx.graphics.getWidth()/2/2, Gdx.graphics.getHeight()/2/2);
//
//	}

