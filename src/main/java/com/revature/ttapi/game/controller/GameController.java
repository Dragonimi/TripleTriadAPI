
package com.revature.ttapi.game.controller;

import com.revature.ttapi.game.models.Game;
import com.revature.ttapi.game.models.GameResponse;
import com.revature.ttapi.game.services.GameService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
    //Thoughts on controller function are that we want it to generate a link or URL that two people can hit to join a game if they are logged in. UI will handle Redirection

    @MessageMapping("/user")
    @SendTo("/game/user")
    public GameResponse gamsState(GameService gameService){
        Game testGame = new Game();
        gameService.setGame(testGame);
        return new GameResponse(gameService);
    }
}

