package com.gpstracker.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoggedInActivity extends Activity {
	
	private Button buttonViewMap;
	private Button buttonSettings;
	private Button buttonLogoutUser;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_logged_in_layout);

		final Context context = this;
		
		buttonViewMap = (Button) findViewById(R.id.buttonViewMap);
		buttonViewMap.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, HistoricMapActivity.class);
				startActivity(intent);
			}
		});
		
		buttonSettings = (Button) findViewById(R.id.buttonSettings);
		buttonSettings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, SettingsActivity.class);
				startActivity(intent);
			}
		});
		
		buttonLogoutUser = (Button) findViewById(R.id.buttonLogoutUser);
		buttonLogoutUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(),
						"User Logout Button Click", Toast.LENGTH_LONG).show();
			}
		});
	}
}
