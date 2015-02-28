package com.gpstracker.client.sender.api;

/**
 * Defines a service that can 
 * @author kenneth
 *
 * @param <T>
 */
public interface DataSenderService<T> {

	public boolean sendData(T t);

}
