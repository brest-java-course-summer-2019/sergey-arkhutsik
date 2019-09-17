package com.epam.brest.summer.courses2019.model;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class DeviceTest {

    private static final Integer DEVICE_ID = 1;
    private static final String DEVICE_NAME = "deviceName";
    private static final String DEVICE_DESCRIPTION = "deviceDescription";
    private static final Integer PARENT_ID = 1;
    private static final String DEVICE_DATE = "2019-07-07-00:00:00";

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

    @Test
    public void getDeviceDate() throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss", Locale.US);
        Date date = formatDate.parse(DEVICE_DATE);
        device.setDeviceDate(date);
        assertTrue(device.getDeviceDate().equals(date));
    }
}
