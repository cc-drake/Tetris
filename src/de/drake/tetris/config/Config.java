package de.drake.tetris.config;

import java.awt.Color;

import de.drake.tetris.input.util.Key;

public class Config {
	
	public final static int SIZE_TEXT = 15;
	
	public final static int SIZE_HEADER = 50;
	
	public final static Color COLOR_TEXT = Color.white;
	
	public final static Color COLOR_BACKGROUND = Color.black;
	
	public final static Color COLOR_TEXTBACKGROUND = Color.darkGray;
	
	/**
	 * Gibt an, ob Sounds aktiviert sein sollen.
	 */
	public static boolean sounds;
	
	/**
	 * Gibt an, wie h?ufig kleine Steine (< 4 Bl?cke) spawnen sollen.
	 */
	public static int stone_small;
	
	/**
	 * Gibt an, wie h?ufig "normale" Steine (aus 4 Bl?cken) spawnen sollen.
	 */
	public static int stone_regular;
	
	/**
	 * Gibt an, wie h?ufig gro?e Steine (aus 5 Bl?cken) spawnen sollen.
	 */
	public static int stone_large;
	
	/**
	 * Gibt an, wie h?ufig Bomben-Steine spawnen sollen.
	 */
	public static int stone_bomb;
	
	/**
	 * Gibt die maximale Steingr??e zur?ck.
	 */
	public static int getMaxSteinSize() {
		if (Config.stone_large > 0)
			return 5;
		if (Config.stone_regular > 0)
			return 4;
		if (Config.stone_small > 0)
			return 3;
		if (Config.stone_bomb > 0)
			return 3;
		throw new Error("Ung?ltige Steingr??e");
	}
	
	/**
	 * Gibt die Anzahl der vertikalen bzw. horizontalen Bl?cke des Preview-Bereichs an
	 */
	public static int getPreviewSize() {
		return Config.getMaxSteinSize() + 2;
	}
	
	/**
	 * Die Breite des Spielfeldes (Anzahl der Spalten)
	 */
	public static int breite;
	
	/**
	 * Die sichtbare H?he des Spielfelds, d.h. die Anzahl der in der GUI dargestellten Zeilen.
	 * Die tats?chliche H?he des Spielfelds ist etwas gr??er, damit die Steine oben herausragen k?nnen.
	 */
	public static int hoehe;
	
	/**
	 * Die initiale Fallgeschwindigkeit der Steine in Felder pro Sekunde.
	 */
	public static double initialSpeed;
	
	/**
	 * Zeit, nach der beim Halten der "Links"-Taste das automatische "Weiterlaufen" des Steins nach
	 * links beginnen soll (in Millisekunden).
	 */
	public static int keyRepeatDelay;
	
	/**
	 * Geschwindigkeit, mit der beim Halten der "Links"-Taste der Stein nach links laufen soll
	 * (in Bewegungen je Sekunde).
	 */
	public static int keyRepeatSpeed;
	
	/**
	 * Das Default-Zeitlimit in Sekunden, nach dem ein Spiel im Combat-Modus beendet wird. Das tats?chliche Zeitlimit wird ?ber den GameMode konfiguriert.
	 */
	public static int timeLimitCombat;
	
	/**
	 * Das Default-Zeitlimit in Sekunden, nach dem ein Spiel im Race-Modus beendet wird. Das tats?chliche Zeitlimit wird ?ber den GameMode konfiguriert.
	 */
	public static int timeLimitRace;
	
	/**
	 * Das Default-Zeitlimit in Sekunden, nach dem ein Spiel im Cheese-Modus beendet wird. Das tats?chliche Zeitlimit wird ?ber den GameMode konfiguriert.
	 */
	public static int timeLimitCheese;
	
	/**
	 * Die Default-Beschleunigung nach Elimination einer Reihe in %. Die tats?chliche Beschleunigung wird ?ber den GameMode konfiguriert.
	 */
	public static double speedIncreaseRow;
	
	/**
	 * Die Default-Beschleunigung je Sekunde in %. Die tats?chliche Beschleunigung wird ?ber den GameMode konfiguriert.
	 */
	public static double speedIncreaseSec;
	
	/**
	 * Die Default-Logik, nach der fertige Reihen den Gegnern "draufgeworfen" werden. Die tats?chliche Logik wird ?ber den GameMode konfiguriert.
	 */
	public static String combatType;
	
	/**
	 * Die Default-Anzahl der Reihen, die im Race-Modus zu eliminieren sind. Die tats?chliche Anzahl wird ?ber den GameMode konfiguriert.
	 */
	public static int raceRows;
	
	/**
	 * Die Default-Anzahl der Reihen, die im Cheese-Modus zu eliminieren sind. Die tats?chliche Anzahl wird ?ber den GameMode konfiguriert.
	 */
	public static int cheeseRows;
	
	/**
	 * Die Default-Tastenbelegung bei Verwendung des Keyboards.
	 */
	public static Key keyboard_left,
			keyboard_right,
			keyboard_down,
			keyboard_drop,
			keyboard_dreh_uzs,
			keyboard_dreh_euzs,
			keyboard_pause,
			keyboard_quit;
	
	/**
	 * Die Default-Tastenbelegung bei Verwendung der Maus.
	 */
	public static Key mouse_left,
			mouse_right,
			mouse_down,
			mouse_drop,
			mouse_dreh_uzs,
			mouse_dreh_euzs,
			mouse_pause,
			mouse_quit;
	
	/**
	 * Die Default-Tastenbelegung bei Verwendung eines Gamepads.
	 */
	public static Key gamepad_left,
			gamepad_right,
			gamepad_down,
			gamepad_drop,
			gamepad_dreh_uzs,
			gamepad_dreh_euzs,
			gamepad_pause,
			gamepad_quit;
	
}