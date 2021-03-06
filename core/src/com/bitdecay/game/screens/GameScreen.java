package com.bitdecay.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitdecay.game.objects.PlayerObject;
import com.bitdecay.jump.collision.BitWorld;
import com.bitdecay.jump.leveleditor.render.LibGDXWorldRenderer;

/**
 * Created by MondayHopscotch on 7/19/2016.
 */
public class GameScreen implements Screen {

    Texture backgroundTexture;
    Sprite backgroundImage;
    LibGDXWorldRenderer worldRenderer = new LibGDXWorldRenderer();

    OrthographicCamera camera = new OrthographicCamera(512, 448);

    SpriteBatch batch = new SpriteBatch();

    BitWorld world = new BitWorld();

    @Override
    public void show() {
        world.setTileSize(32);
        backgroundTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
        backgroundImage = new Sprite(backgroundTexture);

        PlayerObject ourPlayer = new PlayerObject();
        world.addBody(ourPlayer.getBody());
    }

    @Override
    public void render(float delta) {
        world.step(world.STEP_SIZE);


        camera.update();
        worldRenderer.render(world, camera);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

//        batch.draw(backgroundImage, 0, 0);

        batch.end();
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

    }
}
