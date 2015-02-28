package com.gpstracker.client.service.exectioner;

import com.gpstracker.client.service.executioner.ServiceExecutioner;

public class NewThreadExecutionService implements ServiceExecutioner<Object> {

	@Override
	public Object execute() {
		
		final Object response = null;
		
		Thread networkThread = new Thread() {
			public void run() {
			}
		};
		networkThread.start();
		
		return response;
	}
}
