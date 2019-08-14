
package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Device;

import java.util.List;
import java.util.Optional;


/**
 * <p>DeviceDao interface.</p>
 *
 * @author archs
 * @version $Id: $Id
 */
public interface DeviceDao {

    /**
     * <p>add.</p>
     *
     * @param device a {@link com.epam.brest.summer.courses2019.model.Device} object.
     * @return a {@link com.epam.brest.summer.courses2019.model.Device} object.
     */
    Device add(Device device);

    /**
     * <p>update.</p>
     *
     * @param device a {@link com.epam.brest.summer.courses2019.model.Device} object.
     */
    void update(Device device);

    /**
     * <p>delete.</p>
     *
     * @param deviceID a {@link java.lang.Integer} object.
     */
    void delete(Integer deviceID);

    /**
     * <p>findAll.</p>
     *
     * @return a {@link java.util.List} object.
     */
    List<Device> findAll();

    /**
     * <p>findByDeviceId.</p>
     *
     * @param deviceId a {@link java.lang.Integer} object.
     * @return a {@link java.util.List} object.
     */
    List<Device> findByDeviceId(Integer deviceId);

    /**
     * <p>findById.</p>
     *
     * @param deviceId a {@link java.lang.Integer} object.
     * @return a {@link java.util.Optional} object.
     */
    Optional<Device> findById(Integer deviceId);

}
