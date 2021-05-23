package shareObject;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import logicEntities.Player;

/**
 * @author Napat
 * Manage the game's save
 */
public class GameSaved {
	private static int openTime;
	private final static Preferences prefs = Preferences.userRoot().node(GameSaved.class.getName());
	private static int player_level;
	private static int experiencePoint;
	private static int experiencePoint_Max;
	private static String player_name;
	private static int sound_level;
	static {
		init();
	}
	/**
	 * Init the player's info from save
	 */
	public static void init() {
		//GameSaved.openTime = prefs.getInt("openTime",0);
		GameSaved.player_level = prefs.getInt("playerLevel",1);
		GameSaved.experiencePoint = prefs.getInt("experiencePoint",0);
		GameSaved.experiencePoint_Max = (int) Math.round(100 * Math.pow(1.5,GameSaved.player_level));
		GameSaved.player_name = prefs.get("playerName", null);
		GameSaved.sound_level = prefs.getInt("soundLevel", 70);
	}
	/**
	 * Give player XP
	 * @param XP
	 */
	public static void gainExperience(int XP) {
		GameSaved.experiencePoint+=XP;
		if(GameSaved.experiencePoint>=GameSaved.experiencePoint_Max) {
			GameSaved.setPlayer_level(GameSaved.player_level+1);
			GameSaved.experiencePoint-=GameSaved.getExperiencePoint_Max();
			Player.getInstance().initBasicPlayer();
		}
		
		prefs.putInt("experiencePoint",GameSaved.experiencePoint);
		GameSaved.experiencePoint_Max = (int) Math.round(100 * Math.pow(1.5,GameSaved.player_level));
	}

	public static Preferences getPrefs() {
		return GameSaved.prefs;	
	}
	public static void clear() {
		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
		}
	}

	public static int getPlayer_level() {
		return player_level;
	}

	public static void setPlayer_level(int player_level) {
		GameSaved.player_level = player_level;
		prefs.putInt("playerLevel", GameSaved.player_level);
	}
	public static String getPlayer_name() {
		return player_name;
	}
	public static void setPlayer_name(String player_name) {
		GameSaved.player_name = player_name;
		prefs.put("playerName", player_name);
	}
	public static int getSound_level() {
		return sound_level;
	}
	public static void setSound_level(int sound_level) {
		GameSaved.sound_level = sound_level;
		prefs.putInt("soundLevel", sound_level);
	}
	public static int getExperiencePoint() {
		return experiencePoint;
	}
	public static void setExperiencePoint(int experiencePoint) {
		GameSaved.experiencePoint = experiencePoint;
	}
	public static int getExperiencePoint_Max() {
		return experiencePoint_Max;
	}
	public static void setExperiencePoint_Max(int experiencePoint_Max) {
		GameSaved.experiencePoint_Max = experiencePoint_Max;
	}
	
}
