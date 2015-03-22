package com.gpstracker.client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HistoricMapActivity extends Activity {
	//private LatLng TutorialsPoint = new LatLng(21, 57);
	//private GoogleMap googleMap;
	private Button buttonBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.historic_map_layout);
		
//		try {
//			if (googleMap == null) {
//				googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//			}
//			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//			Marker TP = googleMap.addMarker(
//					new MarkerOptions().position(TutorialsPoint).title("TutorialsPoint"));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		buttonBack = (Button) findViewById(R.id.buttonMapBack);
		buttonBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Map Back Button Click", Toast.LENGTH_LONG).show();
			}
		});
	}
}
