package lib.utils;

import lib.Temperature;

public class UseResult {
    public final boolean success;
    public final Temperature temp;

    public UseResult(boolean success, Temperature temp) {
        this.success = success;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "UseResult(" + this.success + ", " + this.temp + ")";
    }
}
