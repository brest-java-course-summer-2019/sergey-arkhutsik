package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceDao {

    Device add(Device device);

    void update(Device device);

    void delete(Integer deviceID);

    List<Device> findAll();
    /**
     * Get Department By Id.
     *
     * @param deviceId departmentId
     * @return Department
     */
    Optional<Device> findById(Integer deviceId);
}
