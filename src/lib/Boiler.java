package lib;

import java.lang.RuntimeException;
import lib.interfaces.Usable;
import lib.utils.UseResult;

public class Boiler implements Usable {
    private Valve valve;
    public Manometr manometr;

    public Boiler(Temperature temp) {
        this.valve = new Valve(temp);
        this.manometr = new Manometr(1);
    }
    
    @Override
    public UseResult use() {
        UseResult useresult = this.valve.use();
        if (useresult.success) {
            this.relievePressure();
        }
        return useresult;
    }

    public Boiler increasePressure() {
        this.manometr.increasePressure(0.25);

        return this;
    }

    private Boiler relievePressure() {
        if (this.isPressureTooHigh()) {
            System.out.println("Boiler's pressure relieved from being too high!");
        }
        
        this.manometr.decreasePressure(0.25);
        return this;
    }

    public boolean isPressureTooHigh() {
        return this.manometr.isTooHigh();
    }

    public void explode() {
        throw new RuntimeException("The 'Overlook' boiler exploded!");
    }

    @Override
    public String toString() {
        return "'Overlook' Boiler";
    }
}
