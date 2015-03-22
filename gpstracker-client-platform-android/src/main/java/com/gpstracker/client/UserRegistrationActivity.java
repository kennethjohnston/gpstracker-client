package com.gpstracker.client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * The activity that represents the users registration.
 */
public class UserRegistrationActivity extends Activity implements OnClickListener {

	private Button buttonRegisterUser;
	private Button buttonBack;
	
	private EditText inputPersonName;
    private EditText inputEmailAddress;
    private EditText inputPhoneNumber;
    private EditText inputUsername;
    private EditText inputPassword;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_registeration_layout);
		
		buttonRegisterUser = (Button) findViewById(R.id.buttonRegisterUser);
		buttonRegisterUser.setOnClickListener(this);

		buttonBack = (Button) findViewById(R.id.buttonRegisterUserBack);
		buttonBack.setOnClickListener(this);
		
		 inputPersonName = (EditText) findViewById(R.id.textInputPersonName);
		 inputEmailAddress = (EditText) findViewById(R.id.textInputEmailAddress);
		 inputPhoneNumber = (EditText) findViewById(R.id.textInputPhoneNumber);
		 inputUsername = (EditText) findViewById(R.id.textInputUserName);
		 inputPassword = (EditText) findViewById(R.id.textInputPassword);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
			case R.id.buttonRegisterUser:
				Toast.makeText(getApplicationContext(), 
						"User Registration Button Click == "
						+ "[ "	+ inputPersonName.getText().toString() + " ]"
						+ "[ "	+ inputEmailAddress.getText().toString() + " ]"
						+ "[ "	+ inputPhoneNumber.getText().toString() + " ]"
						+ "[ "	+ inputUsername.getText().toString() + " ]"
						+ "[ "	+ inputPassword.getText().toString() + " ]",
						Toast.LENGTH_LONG).show();
				break;
	
			case R.id.buttonRegisterUserBack:
				Toast.makeText(getApplicationContext(),"User Registration Back Button Click", Toast.LENGTH_LONG).show();
				break;
		}
	}
}
