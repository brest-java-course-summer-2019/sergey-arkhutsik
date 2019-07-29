package com.epam.brest.summer.cources2019.service;

import com.epam.brest.summer.courses2019.model.Device;
import java.util.List;


public interface DeviceService {

    /**
     * Find all devices stream.
     *
     * @return devices .
     */
    List<Device> findAll();

    /**
     * Find Device By Id.
     *
     * @param id id
     * @return Device
     */
    Device findById(Integer id);

    /**
     * Update department.
     *
     * @param device device
     */
    void update(Device device);

    /**
     * Delete Device.
     *
     * @param id device id
     */
    void delete(int id);
}
