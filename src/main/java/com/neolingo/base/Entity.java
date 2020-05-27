package com.neolingo.base;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created By p.yost on 20.05.2020
 */
public class Entity {

    protected int hoursUntilExpiration;

    @NotNull
    @Getter
    protected final String id;

    @NotNull
    @Getter
    protected final Date created;

    @Getter
    @NotNull
    public Date expirationTime;

    public Entity(int hoursUntilExpiration) {
        this.hoursUntilExpiration = hoursUntilExpiration;
        id = UUID.randomUUID().toString();
        created = new Date();
        extendExpiration();
    }

    public Entity extendExpiration(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, this.hoursUntilExpiration);
        this.expirationTime = calendar.getTime();
        return this;
    }
}
