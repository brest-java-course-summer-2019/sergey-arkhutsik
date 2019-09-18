package com.epam.brest.summer.courses2019.model.stub;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * POJO Client for model.
 */
public class ClientStub {

    /**
     * Client Id.
     */
    private Integer clientId;

    /**
     * Client Name.
     */
    @NotEmpty(message = "Client name can not be empty.")
    @Size(min = 1, max = 255, message = "Client name must be between 2 and 50 characters.")
    private String clientName;

    /**
     * Count of Clients Devices.
     */
    private Integer countOfDevices;

    /**
     * Constructor without arguments.
     */
    public ClientStub() {
    }

    /**
     * Constructor with client name.
     *
     * @param clientName client name
     */
    public ClientStub(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Returns <code>Integer</code> representation of this clientId.
     *
     * @return clientId Client Id.
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * Sets the client's identifier.
     *
     * @param clientId Client Id.
     */
    public void setClientId(final Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * Returns <code>String</code> representation of this clientName.
     *
     * @return clientName Client Name.
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets the client's name.
     *
     * @param clientName Client Name.
     */
    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }

    /**
     * Returns <code>Integer</code> representation of countOfDevices
     * for the Client.
     *
     * @return clientId.
     */
    public Integer getcountOfDevices() {
        return countOfDevices;
    }

    /**
     * Sets the client's countOfDevices.
     *
     * @param countOfDevices count Of Devices.
     */
    public void setcountOfDevices(final Integer countOfDevices) {
        this.countOfDevices = countOfDevices;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ClientStub{"
                + "clientId=" + clientId
                + ", clientName='" + clientName + '\''
                + ", countOfDevices=" + countOfDevices
                + '}';
    }
}
