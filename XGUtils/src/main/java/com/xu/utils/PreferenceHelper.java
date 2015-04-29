package com.xu.utils;

import android.content.SharedPreferences;

import com.xu.App;

/**
 *
 */
public class PreferenceHelper {
	public PreferenceHelper() {
	}

	public static boolean readBoolean(
			String paramString1, String paramString2) {
		return App.getAppContext().getSharedPreferences(paramString1, 0).getBoolean(
				paramString2, false);
	}

	public static boolean readBoolean(
			String paramString1, String paramString2, boolean paramBoolean) {
		return App.getAppContext().getSharedPreferences(paramString1, 0).getBoolean(
				paramString2, paramBoolean);
	}

	public static int readInt( String paramString1,
			String paramString2) {
		return App.getAppContext().getSharedPreferences(paramString1, 0).getInt(
				paramString2, 0);
	}

	public static int readInt( String paramString1,
			String paramString2, int paramInt) {
		return App.getAppContext().getSharedPreferences(paramString1, 0).getInt(
				paramString2, paramInt);
	}

	public static String readString( String paramString1,
			String paramString2) {
		return App.getAppContext().getSharedPreferences(paramString1, 0).getString(
				paramString2, null);
	}

	public static String readString( String paramString1,
			String paramString2, String paramString3) {
		return App.getAppContext().getSharedPreferences(paramString1, 0).getString(
				paramString2, paramString3);
	}

	public static void write( String paramString1,
			String paramString2, int paramInt) {
		SharedPreferences.Editor localEditor = App.getAppContext()
				.getSharedPreferences(paramString1, 0).edit();
		localEditor.putInt(paramString2, paramInt);
		localEditor.commit();
	}

	public static void write( String paramString1,
			String paramString2, String paramString3) {
		SharedPreferences.Editor localEditor = App.getAppContext()
				.getSharedPreferences(paramString1, 0).edit();
		localEditor.putString(paramString2, paramString3);
		localEditor.commit();
	}

	public static void write( String paramString1,
			String paramString2, boolean paramBoolean) {
		SharedPreferences.Editor localEditor = App.getAppContext()
				.getSharedPreferences(paramString1, 0).edit();
		localEditor.putBoolean(paramString2, paramBoolean);
		localEditor.commit();
	}
}