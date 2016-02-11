package com.example.game.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class PlayerControler {

    private Rectangle PlayerRect;
    private Texture Player;
    private static Polygon polygon;

    public PlayerControler(Texture Player){
        this.Player = Player;
        PlayerRect = new Rectangle();
        PlayerRect.set(400, 220, 64, 64);

        polygon = new Polygon(new float[]{0,0,PlayerRect.width,0,PlayerRect.width,PlayerRect.height,0,PlayerRect.height});
    }

    public void MovePlayer() {
        float accelerationX = Gdx.input.getAccelerometerX();
        float accelerationY = Gdx.input.getAccelerometerY();

        if (PlayerRect.x > 30 && PlayerRect.x < 710 && PlayerRect.y > 30 && PlayerRect.y < 390) {
            PlayerRect.x -= accelerationY * com.example.game.GameLogic.GameLevels.PLAYER_SPEED * Gdx.graphics.getDeltaTime();
            PlayerRect.y += accelerationX * com.example.game.GameLogic.GameLevels.PLAYER_SPEED * Gdx.graphics.getDeltaTime();
        } else {
           com.example.game.GameLogic.GameState.SetGameState(3); // 3 = Game Over
        }
    }

    public Rectangle getPlayerRect() {
        return PlayerRect;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public static boolean CheckColision(Polygon polygon){
        boolean toReturn = false;
        if(Intersector.overlapConvexPolygons(PlayerControler.polygon, polygon)){
            toReturn = true;
        }
        return toReturn;
    }
}
