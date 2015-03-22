package com.gpstracker.client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingsActivity extends Activity {
	private Button buttonUpdateSettings;
	private Button buttonBack;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_layout);
		
		buttonUpdateSettings = (Button) findViewById(R.id.buttonUpdateSettings);
		buttonUpdateSettings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Update Settings Button Click", Toast.LENGTH_LONG).show();
			}
		});

		buttonBack = (Button) findViewById(R.id.buttonSettingsBack);
		buttonBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Update Settings Back Button Click", Toast.LENGTH_LONG).show();
			}
		});
	}
}
