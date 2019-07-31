package com.epam.brest.summer.courses2019.model;

public class Device {

    private Integer deviceId;

    private String deviceDate;

    private String deviceModel;

    private String deviceDescription;

    private Integer clientId;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(String deviceDate) {
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