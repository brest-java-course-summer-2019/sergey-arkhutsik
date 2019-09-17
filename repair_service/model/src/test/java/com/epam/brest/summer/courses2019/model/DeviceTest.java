package com.epam.brest.summer.courses2019.model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class DeviceTest {

    private static final Integer DEVICE_ID = 1;
    private static final String DEVICE_NAME = "deviceName";
    private static final String DEVICE_DESCRIPTION = "deviceDescription";
    private static final Integer PARENT_ID = 1;

    Device device = new Device();

    @Test
    public void getDeviceId() {
        device.setDeviceId(DEVICE_ID);
        assertTrue(device.getDeviceId().equals(DEVICE_ID));
    }

    @Test
    public void getDeviceName() {
        device.setDeviceName(DEVICE_NAME);
        assertTrue(device.getDeviceName().equals(DEVICE_NAME));
    }

    @Test
    public void getParentId() {
        device.setParentId(PARENT_ID);
        assertTrue(device.getParentId().equals(PARENT_ID));
    }

    @Test
    public void getDeviceDescription() {
        device.setDeviceDescription(DEVICE_DESCRIPTION);
        assertTrue(device.getDeviceDescription().equals(DEVICE_DESCRIPTION));
    }

}
