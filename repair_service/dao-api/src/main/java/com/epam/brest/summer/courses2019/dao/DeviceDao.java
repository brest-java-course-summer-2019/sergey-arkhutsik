package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Device;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Device DAO Interface.
 */
public interface DeviceDao {

    /**
     * Get all devices.
     *
     * @return list of all devices
     */
    List<Device> findAll();

    /**
     * Get device with specified id.
     *
     * @param deviceId device id
     * @return device by id
     */
    Optional<Device> findById(Integer deviceId);

    /**
     * Persist new device.
     *
     * @param device device
     * @return device
     */
    Device addDevice(Device device);

    /**
     * Update device.
     *
     * @param device device
     */
    void update(Device device);

    /**
     * Delete device with specified id.
     *
     * @param deviceId client id
     */
    void delete(Integer deviceId);

}