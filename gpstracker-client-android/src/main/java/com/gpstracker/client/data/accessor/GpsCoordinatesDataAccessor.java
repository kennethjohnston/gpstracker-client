package com.gpstracker.client.data.accessor;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;

public class GpsCoordinatesDataAccessor extends Activity {
	// Acquire a reference to the system Location Manager
	LocationManager locationManager = (LocationManager)	getSystemService(Context.LOCATION_SERVICE);


}
