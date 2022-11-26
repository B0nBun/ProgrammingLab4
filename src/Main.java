import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lib.location.Location;
import lib.location.Room;
import lib.*;
import lib.entities.Creature;
import lib.entities.JackTorrance;
import lib.exceptions.OverlookExplosionException;
import lib.exceptions.UseFailureException;
import lib.interfaces.Damagable;

public class Main {	
	private static class OverlookPipe implements Damagable {
		static int count = 0;
		int pipeNumber;
		
		public OverlookPipe() {
			OverlookPipe.count += 1;
			this.pipeNumber = OverlookPipe.count;
		}

		public void damage() {
			System.out.println("Overlook pipe #" + this.pipeNumber + " spew flames");
		}
	}
	
	public static void main(String[] args) throws UseFailureException {
		// Setting up a scene
		var jackTorrance = new JackTorrance();
		var creature = new Creature()
			.possess(jackTorrance);
			
		var basement = new Room("basement")
			.addDamagable(new Damagable() {
				public void damage() {
					System.out.println("The firebox exploded");
				}	
			});
		var hall = new Room("hallway");
		var boilerRoom = new Room("boiler-room");
		var room217 = new Room("hotel-room #217")
			.addDamagable(new Damagable() {
				public void damage() {
					System.out.println("The bath broke in two pieces");
				}
			});
		var roof = new Room("roof");
		
		// Adding five pipes
		Stream.iterate(0, i -> i + 1)
			.limit(5)
			.map(x -> new OverlookPipe())
			.forEach(roof::addDamagable);
		
		
		var location = new Location()
			.addRoom(room217)
			.addRoom(basement, new ArrayList<>(List.of(jackTorrance, creature)))
			.addRoom(hall)
			.addRoom(boilerRoom)
			.addRoom(roof);

		var boiler = new Boiler(Temperature.Melting);

		// Playing the scene
		creature
			.feel(Emotion.Fear)
			.feel(Emotion.Panic);
		creature.speaks("Нельзя! О нет, нельзя!");
		boiler.increasePressure();
		location.transferTo(creature, hall);
		boiler.increasePressure();
		location.transferTo(creature, boilerRoom);
		creature.speaks("Нет, этого нельзя допустить!");
		boiler.increasePressure();

		try {
			creature.uses(boiler);
	
			creature
				.stopFeeling(Emotion.Fear)
				.stopFeeling(Emotion.Panic)
				.feel(Emotion.Ecstasy);

			return;
		} catch (OverlookExplosionException err) {
			creature.speaks("Нет! Нельзя! Нельзя! НЕЛЬЗЯ!");
			location.damage();
			throw err;
		} catch (UseFailureException err) {
			System.out.println("Creature failed to use the valve");
			location.damage();
			throw new OverlookExplosionException();
		}
	}
}
