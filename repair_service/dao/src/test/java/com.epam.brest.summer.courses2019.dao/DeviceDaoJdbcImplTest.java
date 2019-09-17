package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Device;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
@Rollback
public class DeviceDaoJdbcImplTest {

    private static final int FIRST_DEVICE_ID = 1;
    private static final String DATE = "2019-07-07";
    private static final String FROM_DATE = "2019-07-11";
    private static final String TO_DATE = "2019-07-22";
    private static final String NEW_DATE = "2019-08-08";
    private static final String DEVICE_NAME = "Test Device";
    private static final String NEW_DEVICE_NAME = "NEW Test Device";
    private static final int PARENT_ID = 1;
    private static final int NEW_PARENT_ID = 2;
    private static final String DEVICE_DESCRIPTION = "Something happened";
    private static final String NEW_DEVICE_DESCRIPTION = "New problem";

    @Autowired
    private DeviceDao deviceDao;

    @Test
    public void testAddDevice() {
        List<Device> devices = deviceDao.findAll();
        int sizeBefore = devices.size();
        Device device = new Device(DEVICE_NAME, PARENT_ID, DEVICE_DESCRIPTION);
        Device addedDevice = deviceDao.addDevice(device);
        assertTrue((sizeBefore + 1) == deviceDao.findAll().size());
    }

    @Test
    public void testUpdateDevice() {
        Device newDevice = deviceDao.findById(1).get();
        newDevice.setDeviceName(NEW_DEVICE_NAME);
        newDevice.setDeviceDescription(NEW_DEVICE_DESCRIPTION);
        newDevice.setParentId(NEW_PARENT_ID);
        deviceDao.update(newDevice);
        Device updatedDevice = deviceDao.findById(newDevice.getDeviceId()).get();
        assertEquals(updatedDevice.getDeviceId(), newDevice.getDeviceId());
        assertEquals(updatedDevice.getDeviceName(), newDevice.getDeviceName());
        assertEquals(updatedDevice.getParentId(), newDevice.getParentId());
    }

    @Test
    public void testDeleteDevice() {
        Device device = deviceDao.addDevice(
                new Device(DEVICE_NAME, PARENT_ID, DEVICE_DESCRIPTION));
        int deletedDeviceId = device.getDeviceId();
        deviceDao.delete(deletedDeviceId);
        assertFalse(deviceDao.findById(deletedDeviceId).isPresent());
    }

    @Test
    public void testFindAllDevices() {
        List<Device> devices = deviceDao.findAll();
        assertFalse(devices.isEmpty());
    }

    @Test
    public void testFindDeviceById() {
        Device testDevice = deviceDao.findById(FIRST_DEVICE_ID).get();
        assertNotNull(deviceDao);
        assertTrue(testDevice.getDeviceId().equals(FIRST_DEVICE_ID));
        assertEquals(testDevice.getDeviceName(), "Ipad Air1");
        assertEquals(testDevice.getDeviceDescription(), "damaged by water");
        assertTrue(testDevice.getParentId().equals(1));
    }

}
