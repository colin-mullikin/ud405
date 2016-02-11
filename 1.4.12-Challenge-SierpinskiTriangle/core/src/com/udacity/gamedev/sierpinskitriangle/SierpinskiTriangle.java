package com.udacity.gamedev.sierpinskitriangle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * TODO: Start here
 *
 * Your challenge, should you choose to accept it, is to draw a Serpinski Triangle. I offer no hints
 * beyond the fact that ShapeRenderer has a very convenient triangle() function, and that using a
 * FitViewport can simplify matters considerably. Good luck!
 */


public class SierpinskiTriangle extends ApplicationAdapter {

    static final float SIZE = 10;
    private static final int RECURSIONS = 4;

    ShapeRenderer renderer;
    FitViewport viewport;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        viewport = new FitViewport(SIZE,SIZE);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(Color.BLACK);
        renderer.triangle(0,0,SIZE/2,SIZE,SIZE,0);

        renderer.setColor(Color.WHITE);
        drawTriangles(RECURSIONS,0,0,SIZE);

        renderer.end();

    }

    public void drawTriangles(int recursions, float x, float y, float size){
        if (recursions == 0){
            return;
        }
        float newSize = size / 2;
        renderer.triangle(x+newSize/2,y+newSize,x+size*3/4,y+newSize,x+newSize,y);
        drawTriangles(recursions-1,x,y,newSize);
        drawTriangles(recursions-1,x+newSize/2,y+newSize,newSize);
        drawTriangles(recursions-1,x+newSize,y,newSize);
    }




}
