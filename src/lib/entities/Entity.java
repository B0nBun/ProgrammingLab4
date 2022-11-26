package lib.entities;

import java.util.HashSet;
import lib.Emotion;
import lib.Temperature;
import lib.exceptions.UseFailureException;
import lib.interfaces.Usable;

public abstract class Entity {
    private HashSet<Emotion> emotions = new HashSet<>();
    

    public Entity(HashSet<Emotion> emotions) {
        this.emotions = emotions;
    }
    
    public Entity feel(Emotion emotion) {
        this.emotions.add(emotion);
        System.out.println(this.name() + " feels " + emotion.toString());
        return this;
    }

    public Entity stopFeeling(Emotion emotion) {
        this.emotions.remove(emotion);
        return this;
    }

    abstract public String name();
    abstract public Entity speaks(String phrase);
    abstract public Temperature uses(Usable thing) throws UseFailureException;

    @Override
    public String toString() {
        return this.name();
    }
}
