package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Device;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
@Transactional
@Rollback
public class DeviceDaoJdbcImplTest {

    @Autowired
    DeviceDao deviceDao;

    private Device device;
    LocalDate testDeviceDate = LocalDate.of(2019, 07, 13);

    @Before
    public void changes() {
    device = new Device(1, "deviceModel1", "needRepair1", testDeviceDate, 1);
    device = deviceDao.add(device);
}

    @After
    public void cleanChanges() {
        deviceDao.delete(device.getDeviceId());
    }

    @Test
    public void findAllDevices() {
        List<Device> devices = deviceDao.findAll();
        assertNotNull(devices);
        assertTrue(devices.size() > 0);
    }

    @Test
    public void findByDeviceId() throws Exception {
        Device testDevice = deviceDao.findById(device.getDeviceId()).get();
        assertNotNull(deviceDao);
        assertEquals(testDevice.getDeviceId(),device.getDeviceId());
        assertTrue(testDevice.getDeviceId().equals(1));
        assertEquals(testDevice.getDeviceModel(),"deviceModel");
        assertEquals(testDevice.getDeviceDescription(), "deviceDescription");
        assertEquals(testDevice.getDeviceDate(), testDeviceDate);
    }

    @Test
    public void addDevice() {
        List<Device> devices = deviceDao.findAll();
        int sizeBefore = devices.size();
        Device device = new Device(2, "deviceModel2", "needRepair2", testDeviceDate, 1);
        Device newDevice = deviceDao.add(device);
        assertNotNull(newDevice.getDeviceId());
        assertEquals(newDevice.getDeviceModel(), device.getDeviceModel());
        assertEquals(newDevice.getDeviceDescription(), device.getDeviceDescription());
        assertEquals(newDevice.getDeviceDate(), device.getDeviceDate());
        assertEquals(newDevice.getClientId(), device.getClientId());
        assertTrue((sizeBefore + 1) == deviceDao.findAll().size());
    }

    @Test
    public void update() {
        LocalDate deviceDate = LocalDate.of(2019, 07, 13);
        Device device = deviceDao.findById(1).get();
        device.setClientId(1);
        device.setDeviceDate(deviceDate);
        device.setDeviceDescription("Device Description");
        device.setDeviceModel("Device Model");
        deviceDao.update(device);
        Device updatedDevice = deviceDao.findById(device.getDeviceId()).get();
        assertTrue(updatedDevice.getDeviceDate().equals(device.getDeviceDate()));
        assertTrue(updatedDevice.getDeviceDescription().equals(device.getDeviceDescription()));
        assertTrue(updatedDevice.getDeviceModel().equals(device.getDeviceModel()));
    }

    @Test
    public void delete() throws Exception {
        LocalDate localDate = LocalDate.of(2019, 07, 07);

        Device device = new Device(2, "deviceModel2", "needRepair2", localDate, 1);
        deviceDao.add(device);
        List<Device> devices = deviceDao.findAll();
        int sizeBefore = devices.size();
        deviceDao.delete(device.getDeviceId());
        assertTrue((sizeBefore - 1) == deviceDao.findAll().size());
}
}
