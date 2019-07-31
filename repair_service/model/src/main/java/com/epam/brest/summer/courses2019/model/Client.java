package com.epam.brest.summer.courses2019.model;

public class Client {

    private Integer clientId;

    private String clientName;


    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
