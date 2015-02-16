package com.gpstracker.client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gpstracker.client.data.accessor.GPSTracker;
import com.gpstracker.client.message.sender.GpsDataSender;

public class MainActivity extends Activity {

	private GpsDataSender gpsSender = new GpsDataSender();
	private int clickCount;
	private Button btnSendGPSData;
	private GPSTracker gps;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		btnSendGPSData = (Button) findViewById(R.id.buttonSendGPS);
        btnSendGPSData.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
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
			}
		});

	}

    @Override
    public void onStart() {
        super.onStart();
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText("GPS Tracker");
    }

}
