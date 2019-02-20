package jcp.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {

    Texture texture;
    Vector2 pos;
    float vy;
    float vx;
    float gravity;
    float moveSpeed;
    int maxSpeed;
    boolean isJumping;

    public Player(){
        texture = new Texture("Player.png");
        pos = new Vector2(100, 300);
        vy = 0;
        vx = 0;
        gravity = -0.4f;
        isJumping = false;
        moveSpeed = 0.4f;
        maxSpeed = 8;
    }


    public boolean touchLands(){
        for (int i = 0; i < Land.lands.length ; i++) {
            if (Land.lands[i].pos.y + 64 >= pos.y){
                isJumping = false;
                return true;
            }
        }
        return false;
    }

    public void jump(){
        isJumping = true;
        gravity = -0.4f;
        vy = 12;
    }



    public void render(SpriteBatch batch){
        batch.draw(texture, pos.x, pos.y);
    }

    public void update(){
        if (touchLands()){
            vy = 0;
            gravity = 0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            if (!isJumping){
                jump();
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if (vx <= maxSpeed){
                vx += moveSpeed;
            }
            pos.x += vx;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if (vx <= maxSpeed){
                vx += moveSpeed;
            }
            pos.x -= vx;
        }

        vy += gravity;
        pos.y += vy;
    }
}
