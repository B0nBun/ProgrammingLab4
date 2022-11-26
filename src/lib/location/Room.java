package lib.location;

import java.lang.reflect.Field;
import java.lang.NoSuchFieldException;
import java.lang.IllegalAccessException;

public class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return '"' + this.name + '"';
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Room) {
            Class<?> cls = other.getClass();
            try {
                Field namefield = cls.getField("name"); 
                return this.name.equals(namefield.get(other));
            } catch (NoSuchFieldException | IllegalAccessException err) {
                return  false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ("Room-" + this.name).hashCode();
    }
}