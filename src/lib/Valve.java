package lib;

import lib.interfaces.Usable;
import lib.utils.UseResult;

public class Valve implements Usable {
    private Temperature temperature;

    public Valve(Temperature temperature) {
        this.temperature = temperature;
    }
    
    private boolean willJam() {
        return Math.random() > 0.4;
    }

    @Override
    public UseResult use() {
        if (this.willJam()) {
            return new UseResult(false, null);
        }
        return new UseResult(true, this.temperature);
    }

    @Override
    public String toString() {
        return "the valve";
    }
}
