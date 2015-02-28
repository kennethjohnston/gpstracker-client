package com.gpstracker.client.data.accessor;

/**
 * Defines the functionality of a data accessor. The 
 *
 * @param <T> the type of data that should be returned from the accessor
 */
public interface DataAcessor<T> {

	T getData();
}
