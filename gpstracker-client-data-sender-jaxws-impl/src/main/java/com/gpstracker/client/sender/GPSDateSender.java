package com.gpstracker.client.sender;

import javax.xml.ws.BindingProvider;

import com.gpstracker.client.autogen.GpsLocation;
import com.gpstracker.client.autogen.GpsLocationService;
import com.gpstracker.client.autogen.GpsLocationServiceService;


public class GPSDateSender {
	
	public static void main(String[] args) {
		new GPSDateSender().sendGPS();
	}
	public boolean sendGPS() {
		GpsLocationServiceService gpsServiceService = new GpsLocationServiceService();
		GpsLocationService gpsService = gpsServiceService.getGpsLocationServicePort();

		// ((BindingProvider)gpsService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY ,  "http://localhost:8080/gpsTracker/gpsTracker");  

		GpsLocation gpsLocation = new GpsLocation();
		gpsLocation.setLatitude("123.22");
		gpsLocation.setLongitude("233.455");
		Object obj = gpsService.gpsLocationRQ(gpsLocation);
		
		return true;
	}

}
