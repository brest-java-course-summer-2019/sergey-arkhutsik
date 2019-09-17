package com.epam.brest.summer.courses2019.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * POJO Device for model.
 */
public class Device {

    /**
     * Device ID.
     */
    private Integer deviceId;

    /**
     * Device Name.
     */
    private String deviceName;

    /**
     * ID of client owning device.
     */
    private Integer parentId;

    /**
     * Date of the device.
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss z yyyy")
    private Date deviceDate;

    /**
     * Device Description.
     */
    private String deviceDescription;

    /**
     * Default constructor.
     */
    public Device() {
    }

    /**
     * Constructor with parameters.
     * @param deviceName - name.
     * @param parentId - client id.
     * @param deviceDate - date.
     * @param deviceDescription - description.
     */
    public Device(String deviceName, Integer parentId, Date deviceDate, String deviceDescription) {
        this.deviceName = deviceName;
        this.parentId = parentId;
        this.deviceDate = deviceDate;
        this.deviceDescription = deviceDescription;
    }

    /**
     * Getter for Device ID.
     * @return device ID.
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * Setter for Device ID
     * @param deviceId - ID.
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Getter for Device Name.
     * @return device name.
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Setter for Device Name
     * @param deviceName - name.
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * Getter for Client ID.
     * @return client ID.
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * Setter for Clients ID.
     * @param parentId - ID.
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * Getter for Device Date.
     * @return device date.
     */
    public final Date getDeviceDate() {
        return deviceDate;
    }

    /**
     * Setter for Device Date.
     * @param deviceDate - date.
     */
    public final void setDeviceDate(final Date deviceDate) {
        this.deviceDate = deviceDate;
    }

    /**
     * Getter for Device Description.
     * @return device description.
     */
    public String getDeviceDescription() {
        return deviceDescription;
    }

    /**
     * Setter for Device Description.
     * @param deviceDescription - description.
     */
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                ", parentId=" + parentId +
                ", deviceDate=" + deviceDate +
                ", deviceDescription='" + deviceDescription + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Device device = (Device) o;

        if (deviceId != device.deviceId) {
            return false;
        }
        return deviceDate != null
                ? deviceDate.equals(device.deviceDate)
                : device.deviceDate == null;
    }

    @Override
    public final int hashCode() {
        int result = deviceId;
        result = 31 * result + (deviceDate != null ? deviceDate.hashCode() : 0);
        return result;
    }
}