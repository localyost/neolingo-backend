package com.neolingo.game;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created By p.yost on 20.05.2020
 */
@Getter
@Setter
public class AddPlayerDTO {

    @NotNull
    private String gameID;

    @NotNull
    private String newPlayerID;
}
