package com.gpstracker.client.data.accessor.gps;

import com.gpstracker.client.data.accessor.DataAcessor;
import com.gpstracker.client.model.gps.GpsLocation;

/**
 * Defines the GPS data accessor. 
 *
 * It is expected that the GPS data accessor will be implemented on a platform
 * by platform basis.
 */
public interface GpsDataAccessor extends DataAcessor<GpsLocation> {

}
