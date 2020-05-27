package com.neolingo.game;

import com.neolingo.base.Entity;
import com.neolingo.player.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created By p.yost on 20.05.2020
 */
@Getter
public class Game extends Entity {

    private final String title;
    private final Set<Player> players = new HashSet<>();

    public Game(String title, Player creator) {
        super(1);
        this.title = title;
        players.add(creator);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

}
