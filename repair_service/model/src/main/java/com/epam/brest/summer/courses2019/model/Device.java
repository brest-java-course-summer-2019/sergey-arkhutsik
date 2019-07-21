package com.epam.brest.summer.courses2019.model;

import java.util.Date;

public class Device {

    private Integer deviceId;

    private Date deviceDate;

    private String deviceModel;

    private Integer clientId;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(Date deviceDate) {
        this.deviceDate = deviceDate;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceDate=" + deviceDate +
                ", deviceModel='" + deviceModel + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}