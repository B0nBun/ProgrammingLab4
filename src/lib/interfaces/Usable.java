package lib.interfaces;

import lib.Temperature;
import lib.exceptions.UseFailureException;

public interface Usable {
    public Temperature use() throws UseFailureException;
}
