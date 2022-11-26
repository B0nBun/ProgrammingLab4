package lib.location;

import java.lang.reflect.Field;
import java.util.ArrayList;

import lib.interfaces.Damagable;

import java.lang.NoSuchFieldException;
import java.lang.IllegalAccessException;

public class Room implements Damagable {
    private String name;
    private ArrayList<Damagable> damagableStuff;

    public Room(String name) {
        this(name, new ArrayList<>());
    }

    public Room(String name, ArrayList<Damagable> damagableStuff) {
        this.name = name;
        this.damagableStuff = damagableStuff;
    }

    public Room addDamagable(Damagable thing) {
        this.damagableStuff.add(thing);
        return this;
    }

    public void damage() {
        System.out.println(this + " is damaged");
        for (Damagable thing : damagableStuff) {
            thing.damage();
        }
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