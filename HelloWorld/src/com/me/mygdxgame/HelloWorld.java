package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.Game;
import com.me.mygdxgame.screens.GameScreen;

public class HelloWorld extends Game {

	public static final String sLOG = HelloWorld.class.getName().substring(HelloWorld.class.getName().lastIndexOf(".")+1);
	public static int msWidth = 800;
	public static int msHeight = 600;
	
	private FPSLogger mFpsLogger;
	
	@Override
	public void create() {
		msWidth = (int)(Gdx.graphics.getDesktopDisplayMode().width * 0.85f);
		msHeight = (int)(Gdx.graphics.getDesktopDisplayMode().height * 0.85f);
		
		Gdx.graphics.setDisplayMode(msWidth, msHeight, false);
		Gdx.app.log(HelloWorld.sLOG, "Creating game" );
        mFpsLogger = new FPSLogger();
        
        setScreen(new GameScreen());
        
	}

	@Override
	public void dispose() {
		Gdx.app.log(HelloWorld.sLOG, "Destroying game" );
		super.dispose();
	}

	@Override
	public void render() {		
		mFpsLogger.log();
		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		
		Gdx.app.log(HelloWorld.sLOG, "Resizing game to: " + width + " x " + height );
		super.resize(width, height);
	}

	@Override
	public void pause() {

		Gdx.app.log(HelloWorld.sLOG, "Pausing game" );
		super.pause();
	}

	@Override
	public void resume() {
		Gdx.app.log(HelloWorld.sLOG, "Resuming game" );
		super.resume();
	}
}
