package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.model.Device;

import java.util.List;

/**
 * Device Service Interface.
 */
public interface DeviceService {

    /**
     * Get all devices.
     *
     * @return list of all devices
     */
    List<Device> findAll();

    /**
     * Get device with specified id.
     *
     * @param id device id
     * @return device by id
     */
    Device findById(Integer id);

    /**
     * Update device.
     *
     * @param device device
     */
    void update(Device device);

    /**
     * Delete device with specified id.
     *
     * @param id device id
     */
    void delete(int id);

    /**
     * Add device.
     *
     * @param device device
     */
    Device addDevice(Device device);
}