package com.neolingo.base;

import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created By p.yost on 20.05.2020
 */
public abstract class GenericService<entity extends Entity> {

    @Getter
    protected final List<entity> entities = new ArrayList<>();

    @Scheduled(cron = "0 0 */1 * * *" )
    protected void cleanEntities(){
        Date now = new Date();
        entities.forEach(entity -> {
            if (now.after(entity.getExpirationTime())) {
                this.removeEntity(entity);
            }
        });
        System.out.println(this.getClass().getSimpleName() +": Cleaning Entities again in 1 Hour");
    }

    protected void removeEntity(entity e) {
        entities.remove(e);
        System.out.println("Removing Entity: " + e.getId() + "from " + this.getClass().getSimpleName());
    }

    @SuppressWarnings("unchecked")
    public entity getEntityById(String id) {
        Optional<entity> entity = entities.stream().filter(p -> p.getId().equals(id)).findFirst();
        return (entity) entity.map(Entity::extendExpiration).orElse(null);
    }
}
