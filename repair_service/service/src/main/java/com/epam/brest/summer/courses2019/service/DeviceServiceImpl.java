package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.dao.DeviceDao;

import com.epam.brest.summer.courses2019.model.Device;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Device Service Interface implementation.
 */
@Component
@Transactional
public class DeviceServiceImpl implements DeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceServiceImpl.class);

    private DeviceDao deviceDao;

    public DeviceServiceImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public List<Device> findAll() {
        LOGGER.debug("Find all devices");
        return deviceDao.findAll();
    }

    @Override
    public Device findById(Integer id) {
        LOGGER.debug("findById({})", id);
        return deviceDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to get device from DB"));
    }

    @Override
    public void update(Device device) {
        LOGGER.debug("update({})", device);
        deviceDao.update(device);
    }

    @Override
    public void delete(int id) {
        LOGGER.debug("delete({})", id);
        deviceDao.delete(id);
    }

    @Override
    public Device addDevice(Device device) {
        return deviceDao.addDevice(device);
    }
}