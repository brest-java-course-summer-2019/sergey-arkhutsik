package com.epam.brest.summer.courses2019.model;

import org.junit.Assert;
import org.junit.Test;

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

}
