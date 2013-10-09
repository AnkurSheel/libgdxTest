package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraHelper {

	public static OrthographicCamera GetCamera(float virtualWidth, float virtualHeight) {
		
		float viewportWidth = virtualWidth;
		float viewportHeight = virtualHeight;
		float physicalWidth = Gdx.graphics.getWidth();
		float physicalHeight = Gdx.graphics.getHeight();
		float aspect = virtualWidth / virtualHeight;
		
		if(physicalWidth / physicalHeight >= aspect) {
			viewportWidth = viewportHeight * (physicalWidth / physicalHeight);
		}
		else {
			viewportHeight = viewportWidth * (physicalHeight / physicalWidth);
		}
		
		OrthographicCamera camera  = new OrthographicCamera(viewportWidth, viewportHeight);
		camera.position.set((int)(virtualWidth * 0.5f), (int)(virtualHeight * 0.5f), 0);
		camera.update();
		return camera;
	}
}
