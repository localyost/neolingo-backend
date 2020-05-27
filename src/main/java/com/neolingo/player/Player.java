package com.neolingo.player;

import com.neolingo.base.Entity;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * Created By p.yost on 20.05.2020
 */
@Getter
public class Player extends Entity {

    public Player(String userName) {
        super(5);
        this.userName = userName;
    }

    @NotNull
    private final String userName;

}
