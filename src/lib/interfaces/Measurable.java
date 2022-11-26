package lib.interfaces;

public interface Measurable {
    public String units();
    public double measure();
    public boolean isTooHigh();
    public boolean isTooLow();
}
