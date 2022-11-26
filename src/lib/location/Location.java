package lib.location;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import lib.entities.Entity;

public class Location {
    private HashMap<Room, ArrayList<Entity>> rooms;

    public Location(HashMap<Room, ArrayList<Entity>> rooms) {
        this.rooms = rooms;
    }

    public Location() {
        this.rooms = new HashMap<>();
    }

    public Location addRoom(Room room, ArrayList<Entity> ents) {
        if (ents.size() != 0) {
            System.out.println(ents.toString() + " are in the room " + room.toString());
        }
        this.rooms.put(room, ents);
        return this;
    }

    public Location addRoom(Room room) {
        this.rooms.put(room, new ArrayList<>());
        return this;
    }
    
    public void transferTo(Entity entity, Room room) {
        ArrayList<Entity> foundEntities = new ArrayList<>();
        
        for (ArrayList<Entity> entities : rooms.values()) {
            Iterator<Entity> itr = entities.iterator();

            while (itr.hasNext()) {
                Entity currentEntity = itr.next();
                if (currentEntity.equals(entity)) {
                    foundEntities.add(currentEntity);
                    itr.remove();
                }
            }
        }

        System.out.println(foundEntities + " transferred to " + room);
        
        for (Entity foundEntity : foundEntities) {
            this.rooms.get(room).add(foundEntity);
        }
    }

    public void comeIn(Entity entity, Room room) {
        this.rooms.get(room).add(entity);
    } 
}