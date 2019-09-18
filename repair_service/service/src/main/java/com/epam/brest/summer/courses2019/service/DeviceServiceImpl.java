package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.dao.DeviceDao;

import com.epam.brest.summer.courses2019.model.Device;

import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
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
    public List<Device> findAll()
        throws DataAccessException {
        LOGGER.debug("Find all devices");
        return deviceDao.findAll();
    }

    @Override
    public Device findById(Integer id)
        throws DataAccessException {
        LOGGER.debug("findById({})", id);
        return deviceDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to get device from DB"));
    }

    @Override
    public void update(Device device)
        throws DataAccessException {
        LOGGER.debug("update({})", device);
        deviceDao.update(device);
    }

    @Override
    public void delete(int id)
        throws DataAccessException {
        LOGGER.debug("delete({})", id);
        deviceDao.delete(id);
    }

    @Override
    public Device addDevice(Device device)
        throws DataAccessException {
        return deviceDao.addDevice(device);
    }

    @Override
    public List<Device> filterDeviceByDate(Date fromDate, Date toDate)
        throws DataAccessException {
        LOGGER.debug("filterDeviceByDate({}, {})", fromDate, toDate);
        return deviceDao.filterDeviceByDate(fromDate, toDate);
    }
}