package jcp.game.data;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Set;

public class Land {
    class SetLand {
        private Texture texture;
        public Vector2 pos;

        public SetLand(Vector2 pos) {
            texture = new Texture("Dirt_block.png");
            this.pos = pos;
        }
    }
    static SetLand[] lands;

    public Land(){
        lands = new SetLand[100];
        for (int i = 0; i < lands.length; i++) {
            lands[i] = new SetLand(new Vector2(i * 64, 0));
        }
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < lands.length; i++) {
            batch.draw(lands[i].texture, lands[i].pos.x, lands[i].pos.y);
        }
    }

    public void update(){

    }
}
