package lib;

import lib.exceptions.OverlookExplosionException;
import lib.exceptions.UseFailureException;
import lib.interfaces.Usable;

public class Boiler implements Usable {
    private Valve valve;
    public Manometr manometr;

    public Boiler(Temperature temp) {
        this.valve = new Valve(temp);
        this.manometr = new Manometr(1);
    }
    
    @Override
    public Temperature use() throws UseFailureException {
        Temperature temp = this.valve.use();
        this.relievePressure();
        return temp;
    }

    public Boiler increasePressure() {
        this.manometr.increasePressure(0.25);

        return this;
    }

    private Boiler relievePressure() {
        if (this.isPressureTooHigh()) {
            this.increasePressure();
            throw new OverlookExplosionException("Boiler's pressure relieved from being too high!");
        }
        
        this.manometr.decreasePressure(0.25);
        return this;
    }

    public boolean isPressureTooHigh() {
        return this.manometr.isTooHigh();
    }

    @Override
    public String toString() {
        return "'Overlook' Boiler";
    }
}
