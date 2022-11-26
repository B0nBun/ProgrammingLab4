package lib;

import lib.interfaces.Measurable;

public class Manometr implements Measurable {
    private double pressure;

    public Manometr(double pressure) {
        this.pressure = pressure;
    }
    
    public Manometr increasePressure(double delta) {
        this.pressure += delta;
        return this;
    }

    public Manometr decreasePressure(double delta) {
        this.pressure -= delta;
        return this;
    }

    @Override
    public double measure() {
        return this.pressure;
    }

    @Override
    public boolean isTooHigh() {
        return this.measure() >= 1.75;
    }

    @Override
    public boolean isTooLow() {
        return this.measure() <= 0.75;
    }
    
    @Override
    public String units() {
        return "bar";
    }
}
