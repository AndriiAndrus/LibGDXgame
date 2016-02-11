package com.example.game.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class Opponent {

    private Rectangle OppRect;
    private Texture OppTexture;
    private boolean HasWay = false;
    private float WayX, WayY;
    private Polygon polygon;

    public Opponent(Texture Enemy, int x, int y){
      OppTexture = Enemy;

        OppRect = new Rectangle();
        OppRect.set(x, y, 64, 64);

        polygon = new Polygon(new float[]{0,0,OppRect.width,0,OppRect.width,OppRect.height,0,OppRect.height});
    }

    public Polygon getPolygon() { return polygon; }

    public Rectangle GetOppRect(){
        return OppRect;
    }

    public Texture getOppTexture() {
        return OppTexture;
    }

    private void SetNewWay(){
        if(OppRect.x > 400)
            WayX = MathUtils.random(-2, -1);
        if(OppRect.x <= 400)
            WayX = MathUtils.random(1, 2);
        if(OppRect.y >= 240)
            WayY = MathUtils.random(-2, -1);
        if(OppRect.y < 240)
            WayY = MathUtils.random(1, 2);
    }

    private void MakeMove(){
        OppRect.x += WayX * com.example.game.GameLogic.GameLevels.OPPONENT_SPEED * Gdx.graphics.getDeltaTime();
        OppRect.y += WayY * com.example.game.GameLogic.GameLevels.OPPONENT_SPEED * Gdx.graphics.getDeltaTime();
    }

    public void Move() {
        CheckColisionPlayer();
        if (OppRect.x >= 30 && OppRect.x <= 710 && OppRect.y >= 30 && OppRect.y <= 390) {
            if (HasWay) {
                MakeMove();
            } else {
                SetNewWay();
                HasWay = true;
            }
        } else {
            HasWay = false;
            SetNewWay();
            MakeMove();
        }
    }

    private void CheckColisionPlayer() {
       if(PlayerControler.CheckColision(polygon)){
           com.example.game.GameLogic.GameState.SetGameState(3); // 3 = GameOver
       }
    }
}
