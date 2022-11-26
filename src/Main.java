import java.util.ArrayList;
import java.util.List;
import lib.location.Location;
import lib.location.Room;
import lib.*;
import lib.entities.Creature;
import lib.entities.JackTorrance;
import lib.exceptions.OverlookExplosionException;
import lib.exceptions.UseFailureException;

public class Main {	
	public static void main(String[] args) throws UseFailureException {
		// Setting up a scene
		var jackTorrance = new JackTorrance();
		var creature = new Creature()
			.possess(jackTorrance);

		var basement = new Room("basement");
		var hall = new Room("hallway");
		var boilerRoom = new Room("boiler-room");
		
		var location = new Location()
			.addRoom(basement, new ArrayList<>(List.of(jackTorrance, creature)))
			.addRoom(hall)
			.addRoom(boilerRoom);

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
			throw err;
		} catch (UseFailureException err) {
			System.out.println("Creature failed to use the valve");
			throw err;
		}
	}
}
