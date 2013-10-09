package com.me.mygdxgame.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen; 
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.me.mygdxgame.CameraHelper;
import com.me.mygdxgame.HelloWorld;
import com.me.mygdxgame.TileData;

public class GameScreen implements Screen {

	private TiledMap mMap;
	private OrthogonalTiledMapRenderer mMapRenderer;
	private OrthographicCamera mCamera;
	private ArrayList<TileData> mTileArray = new ArrayList<TileData>(); 
	
	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// move map
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			mCamera.translate(-3, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			mCamera.translate(3, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			mCamera.translate(0, -3);
		}
		if(Gdx.input.isKeyPressed(Keys.UP)){
			mCamera.translate(0, 3);
		}
		if(Gdx.input.isKeyPressed(Keys.PLUS)){
			mCamera.zoom -= 0.02;
		}
		if(Gdx.input.isKeyPressed(Keys.MINUS)){
			mCamera.zoom += 0.02;
		}		
		if(Gdx.input.isKeyPressed(Keys.A)){
			mCamera.rotate(-1);
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			mCamera.rotate(1);
		}

		mCamera.update();
		mMapRenderer.setView(mCamera);
		mMapRenderer.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {

		createTileMap();
		
		int mapWidth = mMap.getProperties().get("width", Integer.class) * mMap.getProperties().get("tilewidth", Integer.class);
		
		float unitScale = HelloWorld.msWidth / mapWidth;
		
		mMapRenderer = new OrthogonalTiledMapRenderer(mMap, unitScale);
		mCamera = CameraHelper.GetCamera(HelloWorld.msWidth, HelloWorld.msHeight);
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

		mMap.dispose();
		mMapRenderer.dispose();
		mTileArray.clear();
	}

	private void createTileMap() {

		TmxMapLoader loader = new TmxMapLoader();
		mMap = loader.load("Tiles/StageMap.tmx");
		TiledMapTileLayer bgLayer =  (TiledMapTileLayer) mMap.getLayers().get("Background");
		for(int i = 0; i < bgLayer.getHeight(); i++) {
			for(int j = 0; j <bgLayer.getWidth(); j++) {
				int movementCost = -1;
				String tileType = "";
				TiledMapTile tile = bgLayer.getCell(j, i).getTile();
				if(tile.getProperties() != null) {
					movementCost = Integer.parseInt(tile.getProperties().get("MovementCost", String.class));
					tileType = tile.getProperties().get("TileType", String.class);
					Gdx.app.log(HelloWorld.sLOG, "i: " + i + " j: " + j + " cost: " + movementCost + " type: " + tileType);
				}
				TileData tileData = new TileData(movementCost, tileType);
				mTileArray.add(tileData);
			}
		}
	}
}
