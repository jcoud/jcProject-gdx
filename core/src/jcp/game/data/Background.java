package jcp.game.data;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import javax.swing.*;

public class Background {
    class BGPicture{
        private Texture texture;
        private Vector2 pos;

        public BGPicture(Vector2 pos){
        texture = new Texture("background.png");
        this.pos = pos;
    }

    }
    private int speed;
    private BGPicture[] backs;

    public Background(){
        speed = 0;
        backs = new BGPicture[2];
        backs[0] = new BGPicture(new Vector2(0,0));
        backs[1] = new BGPicture(new Vector2(1920, 0));
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < backs.length ; i++) {
            batch.draw(backs[i].texture, backs[i].pos.x, backs[i].pos.y);
        }
    }

    public void update(){
        for (int i = 0; i < backs.length ; i++) {
            backs[i].pos.x -= speed;
        }

        if (backs[0].pos.x < -1920){
            backs[0].pos.x = 0;
            backs[1].pos.x = 1920;
        }
    }
}
