package com.epam.brest.summer.courses2019.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * POJO Client for model.
 */
public class Client {

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
     * Constructor without arguments.
     */
    public Client() {
    }

    /**
     * Constructor with client name.
     *
     * @param clientName client name
     */
    public Client(String clientName) {
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
    public Client setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Client{"
                + "clientId=" + clientId
                + ", clientName='" + clientName + '\''
                + '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Client client = (Client) o;

        if (clientId != client.clientId) {
            return false;
        }
        return clientName != null
                ? clientName.equals(client.clientName)
                : client.clientName == null;
    }

    @Override
    public final int hashCode() {
        int result = clientId;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        return result;
    }
}
