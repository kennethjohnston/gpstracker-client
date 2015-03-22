package com.gpstracker.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gpstracker.client.data.accessor.GPSTracker;
import com.gpstracker.client.sender.GpsDataSender;

public class MainActivity extends Activity implements OnClickListener {
	private Button buttonLogIn;
	private Button buttonRegister;
	private Button buttonLoggedIn;
	
	private GpsDataSender gpsSender = new GpsDataSender();
	private int clickCount;
	private Button btnSendGPSData;
	private GPSTracker gps;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);		
		
		buttonLogIn = (Button) findViewById(R.id.buttonLogIn);
		buttonLogIn.setOnClickListener(this);

		buttonRegister = (Button) findViewById(R.id.buttonRegister);
		buttonRegister.setOnClickListener(this);
		
		buttonLoggedIn = (Button) findViewById(R.id.buttonLoggedIn);
		buttonLoggedIn.setOnClickListener(this);
		
		btnSendGPSData = (Button) findViewById(R.id.buttonSendGPS);
        btnSendGPSData.setOnClickListener(this);

	}

    @Override
    public void onStart() {
        super.onStart();
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText("GPS Tracker");
    }

    /**
     * Handles the onClick event for event clicks related to the current activity.
     * 
     * @param view the view
     */
	@Override
	public void onClick(View v) {
		Context context = this;
		switch (v.getId()) {
			case R.id.buttonLogIn: {
				Intent intent = new Intent(context, LoginActivity.class);
				startActivity(intent);
				break;
			}
			case R.id.buttonRegister: {
				Intent intent = new Intent(context, UserRegistrationActivity.class);
	            startActivity(intent);
				break;
			}
			case R.id.buttonLoggedIn: {
				Intent intent = new Intent(context, LoggedInActivity.class);
	            startActivity(intent);
	            break;
			}
			case R.id.buttonSendGPS: {
				try {
					gps = new GPSTracker(MainActivity.this);
	                if (gps.canGetLocation()) {
	                    double latitude = gps.getLatitude();
	                    double longitude = gps.getLongitude();
						String requestResponse = gpsSender.sendGPSData(longitude, latitude);
						TextView txtView = (TextView) findViewById(R.id.text_view);
						txtView.setText("Data sent. " + requestResponse + "\n\nButton press count: " + ++clickCount);
	                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
	                } else {
	                    gps.showSettingsAlert();
	                }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            break;
			}
			
		}
	}

}
