package lib.entities;

import lib.Temperature;
import lib.exceptions.UseFailureException;
import lib.interfaces.Usable;
import java.util.HashSet;

public class Creature extends Entity {
    private Entity possessedEntity;

    public Creature() {
        super(new HashSet<>());
    }

    @Override
    public String name() {
        return "Creature";
    }

    public Creature possess(Entity entity) {
        this.possessedEntity = entity;
        return this;
    }

    public Entity possessed() {
        return this.possessedEntity;
    }

    @Override
    public Creature speaks(String phrase) {
        System.out.println("Creature speaks as " + this.possessedEntity.name() + ": \"" + phrase + '"');
        return this;
    }

    @Override
    public Temperature uses(Usable thing) throws UseFailureException {
        int i = 0;
        while (i < 5) {
            i ++;
            try {
                Temperature temp = this.possessedEntity.uses(thing);
                return temp;
            } catch (UseFailureException err) {
                continue;
            }
        }
        throw new UseFailureException("Creature couldn't use this thing: " + thing);
    }

    @Override
    public boolean equals(Object other) {
        return this == other || this.possessedEntity == other;
    }
}
