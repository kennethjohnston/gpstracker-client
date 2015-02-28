package com.gpstracker.client.service.executioner;

/**
 * Defines how a service should be executed.
 *
 * @param <T> the type of the response expected from the exection
 */
public interface ServiceExecutioner<T>{
	
	T execute();

}
