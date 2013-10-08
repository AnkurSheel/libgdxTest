package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;

public class HelloWorld implements ApplicationListener {

	private static final String LOG = HelloWorld.class.getSimpleName();
		
	private FPSLogger fpsLogger;
	
	@Override
	public void create() {		
		
		Gdx.app.log(HelloWorld.LOG, "Creating game" );
        fpsLogger = new FPSLogger();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 1f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		fpsLogger.log();
	}

	@Override
	public void resize(int width, int height) {
		
		Gdx.app.log(HelloWorld.LOG, "Resizing game to: " + width + " x " + height );
	}

	@Override
	public void pause() {
		
		Gdx.app.log(HelloWorld.LOG, "Pausing game" );
	}

	@Override
	public void resume() {
		
		Gdx.app.log(HelloWorld.LOG, "Resuming game" );
	}
}
