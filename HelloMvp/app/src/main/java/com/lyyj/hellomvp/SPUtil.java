package com.lyyj.hellomvp;


import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SPUtil {

	private static SharedPreferences preferences = BaseApplication.getApplication().getSharedPreferences("hellomvp", Activity.MODE_PRIVATE);
	
	public static String getString(String spName){
		return getString(spName, "");
	}
	
	public static String getString(String spName, String defaultStr){
		return preferences.getString(spName, defaultStr);
	}
	
	public static boolean getBoolean(String spName, boolean defaultBool){
		return preferences.getBoolean(spName, defaultBool);
	}
	
	public static float getFloat(String spName, float defaultflo){
		return preferences.getFloat(spName, defaultflo);
	}
	
	public static int getString(String spName, int defaultInt){
		return preferences.getInt(spName, defaultInt);
	}
	
	public static long getString(String spName, long defaultLon){
		return preferences.getLong(spName, defaultLon);
	}
	
	public static int getInt(String spName, int defaultValue){
		return preferences.getInt(spName, defaultValue);
	}
	
	public static void putString(String spName, String spStr){
		Editor editor=preferences.edit();
		editor.putString(spName, spStr);
		editor.commit();
	}
	
	public static void putBoolean(String spName, boolean spBoolean){
		Editor editor=preferences.edit();
		editor.putBoolean(spName, spBoolean);
		editor.commit();
	}
	
	public static void putFloat(String spName, float spFloat){
		Editor editor=preferences.edit();
		editor.putFloat(spName, spFloat);
		editor.commit();
	}
	
	public static void putInt(String spName, int spInt){
		Editor editor=preferences.edit();
		editor.putInt(spName, spInt);
		editor.commit();
	}
	
	public static void putString(String spName, long spLong){
		Editor editor=preferences.edit();
		editor.putLong(spName, spLong);
		editor.commit();
	}
	
}
