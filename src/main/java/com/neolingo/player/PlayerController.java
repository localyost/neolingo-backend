package com.neolingo.player;

import com.neolingo.exception.NonExistentPlayerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created By p.yost on 20.05.2020
 */
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Player createPlayer(@RequestBody PlayerDTO newPlayer) {
        return playerService.addPlayer(newPlayer);
    }

    @RequestMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Player getPlayer(@PathVariable String id) {
        Player player = playerService.getEntityById(id);
        if (player == null) {
            throw new NonExistentPlayerException();
        }
        return player;
    }


}
