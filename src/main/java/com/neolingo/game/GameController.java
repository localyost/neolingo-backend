package com.neolingo.game;

import com.neolingo.exception.NonExistentPlayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created By p.yost on 20.05.2020
 */
@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameService gameService;


    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Game createGame(@RequestBody GameDTO newGame) throws NonExistentPlayerException {
        return gameService.addGame(newGame);
    }

    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Game addPlayer(@RequestBody AddPlayerDTO newPlayer) throws NonExistentPlayerException {
        return gameService.addPlayer(newPlayer);
    }

}
