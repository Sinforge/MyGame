package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.HashMap;

public class ScreenRenderer {
    private SpriteBatch batch;
    private Texture texture;
    private Array<Texture> balls;




    public ScreenRenderer(SpriteBatch batch) {
        this.batch = batch;
    }



    public void drawBalls (Array<Texture> balls, Array<Rectangle> balls_rec, int ball_size) {
        for (int i =0; i< 8; i++) {
            batch.draw(balls.get(i), balls_rec.get(i).x,balls_rec.get(i).y, ball_size, ball_size);
        }
    }
}
