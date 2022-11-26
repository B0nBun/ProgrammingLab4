package lib;

import lib.exceptions.UseFailureException;
import lib.interfaces.Usable;

public class Valve implements Usable {
    private Temperature temperature;

    public Valve(Temperature temperature) {
        this.temperature = temperature;
    }
    
    private boolean willJam() {
        return Math.random() > 0.4;
    }

    @Override
    public Temperature use() throws UseFailureException {
        if (this.willJam()) {
            throw new UseFailureException("The valve jammed!");
        }
        return this.temperature;
    }

    @Override
    public String toString() {
        return "the valve";
    }
}
