package lib.interfaces;

public interface Damagable {
    default void damage() {
        System.out.println(this + " was damaged");
    }
}
