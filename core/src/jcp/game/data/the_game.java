package jcp.game.data;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class the_game extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Player player;
	Land land;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		player = new Player();
		land = new Land();
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		player.render(batch);
		land.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void update() {
		background.update();
		player.update();
		land.update();
	}
}
