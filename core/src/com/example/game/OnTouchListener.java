package com.example.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.example.game.Controller.ButtonClick;
import com.example.game.GameLogic.GameLevels;
import com.example.game.Models.Buttons;
import com.example.game.Screen.GameOverWindow;

public class OnTouchListener implements InputProcessor {

    private static Vector3 BeginPos;
    private static Vector3 EndPos;

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
      ButtonClick.isButtonTouched(MyGame.ScreenToCamera(screenX, screenY));
        BeginPos = new Vector3(MyGame.ScreenToCamera(screenX, screenY));
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        EndPos = new Vector3(MyGame.ScreenToCamera(screenX, screenY));
        try {
         //   Changing game level with swipe here
            if (Buttons.getLevelerRect().contains(BeginPos.x, BeginPos.y)) {
                if (BeginPos.x+50 < EndPos.x && GameLevels.DIFFICULTY < GameLevels.MAX_DIFF) {
                    GameLevels.DIFFICULTY++;
                    GameLevels.TextLvl = "" + GameLevels.DIFFICULTY;
                } else if (BeginPos.x-50 > EndPos.x && GameLevels.DIFFICULTY > 1) {
                    GameLevels.DIFFICULTY--;
                    GameLevels.TextLvl = "" + GameLevels.DIFFICULTY;
                }
            }
        } catch(Exception ex){ /* later */ }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
