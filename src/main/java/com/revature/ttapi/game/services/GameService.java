package com.revature.ttapi.game.services;

import com.revature.ttapi.game.models.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private Game Game;

    public GameService(Game game){
        this.Game = game;
    }

    //Game Actions: Play a Card(in empty location(handle in UI), Get/Pass Gamestate
    //TODO Learn how to pass game state gracefully.
    //Update State when a player plays a card.
    //UI level close of the game results in no DB updating for MGP(Handled not here but on UI/Websocket DTO? maybe


    public com.revature.ttapi.game.models.Game getGame() {
        return Game;
    }

    public void setGame(com.revature.ttapi.game.models.Game game) {
        Game = game;
    }
}
