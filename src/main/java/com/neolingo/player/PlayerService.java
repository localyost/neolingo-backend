package com.neolingo.player;

import com.neolingo.base.GenericService;
import org.springframework.stereotype.Service;

/**
 * Created By p.yost on 20.05.2020
 */
@Service
public class PlayerService extends GenericService<Player> {

    public Player addPlayer(PlayerDTO playerDTO) {
        Player newPlayer = new Player(playerDTO.getUserName());
        this.entities.add(newPlayer);
        System.out.println("Add Player: " + newPlayer.getId());
        return newPlayer;
    }

}
