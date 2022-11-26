package lib.entities;

import lib.interfaces.Usable;
import lib.utils.UseResult;
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
    public UseResult uses(Usable thing) {
        UseResult useresult = null;
        int i = 0;

        while ((useresult == null || !useresult.success) && (i < 5)) {
            System.out.println("Creature tries to use " + thing.toString());
            useresult = this.possessedEntity.uses(thing);
            i ++;
        }

        return useresult;
    }

    @Override
    public boolean equals(Object other) {
        return this == other || this.possessedEntity == other;
    }
}
