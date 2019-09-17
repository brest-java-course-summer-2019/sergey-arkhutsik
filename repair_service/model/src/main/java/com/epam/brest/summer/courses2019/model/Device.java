package com.epam.brest.summer.courses2019.model;

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
     * @param deviceDescription - description.
     */
    public Device(String deviceName, Integer parentId, String deviceDescription) {
        this.deviceName = deviceName;
        this.parentId = parentId;
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
                ", deviceDescription='" + deviceDescription + '\'' +
                '}';
    }
}