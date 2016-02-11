package com.example.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.example.game.GameLogic.GameState;
import com.example.game.Models.Buttons;
import com.example.game.Models.GameObjects;

import java.util.Date;

public class ButtonClick {

    public static void isButtonTouched(Vector3 vector) {
        switch (GameState.getState()) {
            case GameState.GAME_READY:
                // GAME_READY
                break;
            case GameState.GAME_RUNNING:
                // GAME_RUNNING
                if(Buttons.getPauseRect().contains(vector.x, vector.y)) {
                    GameState.SetGameState(2);
                    GameState.PAUSE_BEGAN = new Date();
                }
                if(Buttons.getMenuBtnRect().contains(vector.x, vector.y))
                    GameState.SetGameState(4);
                break;
            case GameState.GAME_PAUSED:
                // GAME_PAUSED
                if(Buttons.getStartBtnRect().contains(vector.x, vector.y)) {
                    GameState.SetGameState(1);
                    GameState.PAUSE_END = new Date();
                }
                break;
            case GameState.GAME_OVER:
                // GAME_OVER
                if(Buttons.getReplayBtnRect().contains(vector.x, vector.y))
                    GameState.SetGameState(0);
                if(Buttons.getMenuBtnRect().contains(vector.x, vector.y))
                    GameState.SetGameState(4);
                break;
            case GameState.GAME_MENU:
                // GAME_MENU
                if(Buttons.getPlayMenuRect().contains(vector.x, vector.y))
                    GameState.SetGameState(0);
                if(Buttons.getSoundOnRect().contains(vector.x, vector.y)) {
                    GameState.SOUND = 1;
                    GameObjects.getBgMusic().play();
                }
                if(Buttons.getSounfOffRect().contains(vector.x, vector.y)) {
                    GameState.SOUND = 0;
                    GameObjects.getBgMusic().stop();
                }
                if(Buttons.getExitRect().contains(vector.x, vector.y))
                    Gdx.app.exit();
                break;
        }
    }
}
