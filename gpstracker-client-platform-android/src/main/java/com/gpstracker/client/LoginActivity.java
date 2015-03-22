package com.gpstracker.client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private Button buttonLoginUser;
	private Button buttonBack;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_login_layout);

		buttonLoginUser = (Button) findViewById(R.id.buttonLoginUser);
		buttonLoginUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "User Login Button Click", Toast.LENGTH_LONG).show();
			}
		});

		buttonBack = (Button) findViewById(R.id.buttonLoginUserBack);
		buttonBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "User Login Back Button Click", Toast.LENGTH_LONG).show();
			}
		});
	}
}
