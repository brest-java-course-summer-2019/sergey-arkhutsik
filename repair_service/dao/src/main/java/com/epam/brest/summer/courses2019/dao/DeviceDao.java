package com.epam.brest.summer.courses2019;

import com.epam.brest.summer.courses2019.model.Device;
import java.util.List;

public interface DeviceDao {

    Device add(Device device);

    void update(Device device);

    void delete(Integer deviceID);

    List<Device> findAll();

}
