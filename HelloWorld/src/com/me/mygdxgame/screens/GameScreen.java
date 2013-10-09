package com.me.mygdxgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen; 
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.me.mygdxgame.CameraHelper;
import com.me.mygdxgame.HelloWorld;

public class GameScreen implements Screen {

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private float angle = 0.0f;
	
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// move map
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			camera.translate(-3, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			camera.translate(3, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			camera.translate(0, -3);
		}
		if(Gdx.input.isKeyPressed(Keys.UP)){
			camera.translate(0, 3);
		}
		if(Gdx.input.isKeyPressed(Keys.PLUS)){
			camera.zoom -= 0.02;
		}
		if(Gdx.input.isKeyPressed(Keys.MINUS)){
			camera.zoom += 0.02;
		}		
		if(Gdx.input.isKeyPressed(Keys.A)){
			angle -= 1;
			camera.rotate(-1);
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			angle += 1;
			camera.rotate(1);
		}

		camera.update();
		renderer.setView(camera);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {

		TmxMapLoader loader = new TmxMapLoader();

		map = loader.load("Tiles/StageMap.tmx");
		float unitScale = HelloWorld.width /(32 * 15);
		renderer = new OrthogonalTiledMapRenderer(map, unitScale);
		camera = CameraHelper.GetCamera(HelloWorld.width, HelloWorld.height);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {

		map.dispose();
		renderer.dispose();
	}

}
