package com.epam.brest.summer.courses2019.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DeviceTest {
    Device device = new Device();

    @Test
    public void getDeviceId(){
        device.setDeviceId(99);
        Assert.assertTrue(device.getDeviceId().equals(99));
    }

    @Test
    public void getDeviceModel(){
        device.setDeviceModel("MacBook Pro");
        Assert.assertTrue(device.getDeviceModel().equals("MacBook Pro"));
    }

    @Test
    public void testToString() {
        LocalDate deviceDate = LocalDate.of(2019, 07, 13);
        device.setDeviceId(21);
        device.setDeviceDate(deviceDate);
        device.setDeviceModel("DeviceModel");
        device.setDeviceDescription("DestroyedLCD1");
        device.setClientId(22);
        String expectedResponseDevice = "Device{deviceId=21, deviceDate='2019-07-13', deviceModel='DeviceModel', " +
                "deviceDescription='DestroyedLCD1', clientId=22}";
        assertEquals(expectedResponseDevice, device.toString());
    }

}
