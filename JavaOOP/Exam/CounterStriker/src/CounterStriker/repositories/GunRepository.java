package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository<Gun> {
    private List<Gun> models;

    public GunRepository() {
       this.models = new ArrayList<>();
    }

    @Override
    public Collection getModels() {
        return this.models;
    }

    @Override
    public void add(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        models.add(gun);

    }

    @Override
    public boolean remove(Gun gun) {
        return models.remove(gun);

    }


    @Override
    public Gun findByName(String name) {
        for (Gun model : models) {
            if (model.getName().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
