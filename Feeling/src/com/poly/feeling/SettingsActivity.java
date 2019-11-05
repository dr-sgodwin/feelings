package com.poly.feeling;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity{
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.myprefs);
        PreferenceManager.setDefaultValues(SettingsActivity.this, R.xml.myprefs, false);

	}
}
