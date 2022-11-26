package lib.entities;

import lib.Temperature;
import lib.interfaces.Usable;
import lib.utils.UseResult;
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
    public UseResult uses(Usable thing) {
        UseResult useresult = thing.use();
        
        if (!useresult.success) {
            return useresult;
        }
        
        if (useresult.temp.hottereq(Temperature.Hot)) {
            System.out.println("Jack Torrance's hands are melting");
        }

        return useresult;
    }

    @Override
    public boolean equals(Object ent) {
        if (ent instanceof Creature) {
            return ((Creature)ent).possessed() == this || ent == this;
        }
        return ent == this;
    }
}
