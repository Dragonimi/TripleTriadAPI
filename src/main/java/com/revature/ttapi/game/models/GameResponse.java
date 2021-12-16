package com.revature.ttapi.game.models;

import com.revature.ttapi.game.services.GameService;

public class GameResponse {

    GameService gameService;

    public GameResponse(){

    }

    public GameResponse(GameService gameService){

        this.gameService = gameService;
    }

}
