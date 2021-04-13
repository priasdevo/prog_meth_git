package shareObject;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class GameSaved {
	private static int openTime;
	private final static Preferences prefs = Preferences.userRoot().node(GameSaved.class.getName());
	private static int player_level;
	private static String player_name;
	public static void init() {
		GameSaved.openTime = prefs.getInt("openTime",0);
		GameSaved.player_level = prefs.getInt("playerLevel",1);
		GameSaved.player_name = prefs.get(player_name, "null");
	}
	public static int getOpenTime() {
		return openTime;
	}

	public static void setOpenTime(int openTime) {
		GameSaved.openTime=openTime;
		prefs.putInt("openTime", openTime);
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
	
}
