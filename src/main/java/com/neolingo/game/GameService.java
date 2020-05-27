package com.neolingo.game;

import com.neolingo.base.GenericService;
import com.neolingo.exception.NonExistentGameException;
import com.neolingo.exception.NonExistentPlayerException;
import com.neolingo.player.Player;
import com.neolingo.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By p.yost on 20.05.2020
 */
@Service
public class GameService extends GenericService<Game> {

    @Autowired
    private PlayerService playerService;

    public Game addGame(GameDTO gameDTO) throws NonExistentPlayerException {
        Player creator = playerService.getEntityById(gameDTO.getCreatorId());
        if (creator == null) {
          throw new NonExistentPlayerException();
        }
        Game game = new Game(gameDTO.getTitle(), creator);
        System.out.println("Add Game: " + game.getId());

        entities.add(game);
        return game;
    }

    public Game addPlayer(AddPlayerDTO addPlayerDTO) throws NonExistentPlayerException {
        Game game = getEntityById(addPlayerDTO.getGameID());
        Player player = playerService.getEntityById(addPlayerDTO.getNewPlayerID());
        if (player == null) {
            throw new NonExistentPlayerException();
        }
        if (game == null) {
            throw new NonExistentGameException();
        }
        game.addPlayer(player);
        return game;

    }

}
