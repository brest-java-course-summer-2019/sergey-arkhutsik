package com.epam.brest.summer.cources2019.service;

import com.epam.brest.summer.courses2019.dao.DeviceDao;
import com.epam.brest.summer.courses2019.model.Device;

import java.util.List;

public class DeviceServiceImpl implements DeviceService{

    private DeviceDao dao;

    public DeviceServiceImpl(DeviceDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Device> findAll() {
        return dao.findAll();
    }

    @Override
    public Device findById(Integer id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to get device from DB"));
    }

    @Override
    public void update(Device device) {
        dao.update(device);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}