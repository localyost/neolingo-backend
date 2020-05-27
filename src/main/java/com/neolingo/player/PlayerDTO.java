package com.neolingo.player;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created By p.yost on 20.05.2020
 */
@Getter
@Setter
public class PlayerDTO {

    @NotNull
    private String userName;

}
