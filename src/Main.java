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
	private static class Roof extends Room {
		private int pipeCount = 0;
		
		public class OverlookPipe implements Damagable {
			private int pipeNumber;

			private OverlookPipe() {
				Roof.this.pipeCount += 1;
				this.pipeNumber = Roof.this.pipeCount;
			}

			public void damage() {
				System.out.println("Overlook pipe #" + this.pipeNumber + " spew flames from " + Roof.this);
			}
		}
		
		public Roof(String name) {
			super(name + "-roof");
		}
	}

	
	public static void main(String[] args) throws UseFailureException {
		// Setting up a scene
		var jackTorrance = new JackTorrance();
		var creature = new Creature()
			.possess(jackTorrance);

		class Door implements Damagable {
			public void damage() {
				System.out.println("The door flew off it's hinges");
			}
		}
			
		var basement = new Room("basement")
			.addDamagable(new Damagable() {
				public void damage() {
					System.out.println("The firebox exploded");
				}	
			})
			.addDamagable(new Door());
		var hall = new Room("hallway")
			.addDamagable(new Door());
		var boilerRoom = new Room("boiler-room");
		var room217 = new Room("hotel-room #217")
			.addDamagable(new Damagable() {
				public void damage() {
					System.out.println("The bath broke in two pieces");
				}
			});
		var westroof = new Roof("west");
		var eastroof = new Roof("east");
		
		// Adding five pipes to roofs
		Stream.iterate(0, i -> i + 1)
			.limit(3)
			.map(x -> westroof.new OverlookPipe())
			.forEach(westroof::addDamagable);
		
		eastroof.addDamagable(eastroof.new OverlookPipe());
		eastroof.addDamagable(eastroof.new OverlookPipe());
		
		
		var location = new Location()
			.addRoom(room217)
			.addRoom(basement, new ArrayList<>(List.of(jackTorrance, creature)))
			.addRoom(hall)
			.addRoom(boilerRoom)
			.addRoom(westroof)
			.addRoom(eastroof);

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
