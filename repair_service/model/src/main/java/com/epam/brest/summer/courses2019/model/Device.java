package com.epam.brest.summer.courses2019.model;

import java.time.LocalDate;

public class Device {

    private Integer deviceId;

    private LocalDate deviceDate;

    private String deviceModel;

    private String deviceDescription;

    private Integer clientId;

    public Device(int i, String deviceModel1, String needRepair1, LocalDate deviceDate, int i1) {
    }

    public Device() {

    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDate getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(LocalDate deviceDate) {
        this.deviceDate = deviceDate;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
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
                ", deviceDate='" + deviceDate + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", deviceDescription='" + deviceDescription + '\'' +
                ", clientId=" + clientId +
                '}';
    }

}