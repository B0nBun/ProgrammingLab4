package lib.entities;

import lib.Temperature;
import lib.exceptions.UseFailureException;
import lib.interfaces.Usable;
import java.util.HashSet;

public class JackTorrance extends Entity {
    public JackTorrance() {
        super(new HashSet<>());
    }
    
    @Override
    public String name() {
        return "Jack Torrance";
    }

    @Override
    public JackTorrance speaks(String phrase) {
        System.out.println("Jack Torrance says: \"" + phrase + '"');
        return this;
    }

    @Override
    public Temperature uses(Usable thing) throws UseFailureException {
        Temperature temp = thing.use();
        
        if (temp.hottereq(Temperature.Hot)) {
            System.out.println("Jack Torrance's hands are melting");
        }

        return temp;
    }

    @Override
    public boolean equals(Object ent) {
        if (ent instanceof Creature) {
            return ((Creature)ent).possessed() == this || ent == this;
        }
        return ent == this;
    }
}
