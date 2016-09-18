package com.udacity.gamedev.stickfigure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * TODO: Start here
 *
 * In this exercise you'll set up a ShapeRenderer, and use it to draw a stick figure. At minimum,
 * you'll need a circle for the head, and five lines for the torso, arms, and legs.
 *
 * Remember to set up a ShapeRenderer you'll need to declare it, initialize it, and dispose of it.
 * Then to actually use the ShapeRenderer you'll need to start a batch of the appropriate type, draw
 * your shapes, and end the batch.
 *
 * We don't have step-by-step TODOs for this one, since the aim is for you to remember the steps for
 * setting up a ShapeRenderer and be able to set one up on your own. Of course, the solution is
 * available if you run into anything confusing.
 */
public class StickFigure extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1,224f/255f,189/255f,1);
        shapeRenderer.circle(200f,250f,30f);
        shapeRenderer.rectLine(200f,100f,200f,250f,10f);
        shapeRenderer.rectLine(150f,150f,200f,200f,10f);
        shapeRenderer.rectLine(200f,200f,260f,235f,10f);
        shapeRenderer.rectLine(160f,40f,200f,110f,10f);
        shapeRenderer.rectLine(240f,40f,200f,110f,10f);
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.circle(190f,260f,5f);
        shapeRenderer.circle(210f,260f,5f);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.arc(200f,240f,10f,180f,180f);
        shapeRenderer.end();

    }
}
