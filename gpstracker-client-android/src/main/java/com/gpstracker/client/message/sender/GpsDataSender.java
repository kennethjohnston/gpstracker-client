package com.gpstracker.client.message.sender;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.widget.TextView;

import com.gpstracker.client.R;

public class GpsDataSender {

	private final String NAMESPACE = "http://webservice.gpstracker.com/";
	private final String URL = "http://services-gpstrackerqa.rhcloud.com/gpsTracker/gpsTracker?wsdl";
	private final String SOAP_ACTION = "http://services-gpstrackerqa.rhcloud.com/gpsTracker/gpsTracker";
	private final String METHOD_NAME = "gpsLocationRQ";

	public static void main(String[] args) {
		new GpsDataSender().sendGPSData(123.23, 456.34);
	}

	public String sendGPSData(final Double longitude, final Double latitude) {

		// Use a future response.

		Thread networkThread = new Thread() {
			SoapPrimitive response = null;

			public void run() {
				// Create SOAP request
				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
				SoapObject gpsLocation = new SoapObject("", "gpsLocation");
				gpsLocation.addProperty("latitude", String.valueOf(latitude));
				gpsLocation.addProperty("longitude", String.valueOf(longitude));
				request.addSoapObject(gpsLocation);

				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				envelope.setOutputSoapObject(request);
				envelope.dotNet = false;
				envelope.implicitTypes = true;

				HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
				androidHttpTransport.debug = true;
				String requestDump = null;
				String responseDump = null;

				try {
					androidHttpTransport.call(SOAP_ACTION, envelope);
					requestDump = androidHttpTransport.requestDump;
					responseDump = androidHttpTransport.responseDump;
					response = (SoapPrimitive) envelope.getResponse();
				} catch (Exception e) {
					responseDump = e.toString();
				}
			}
		};
		networkThread.start();

		return "response";
	}

}
