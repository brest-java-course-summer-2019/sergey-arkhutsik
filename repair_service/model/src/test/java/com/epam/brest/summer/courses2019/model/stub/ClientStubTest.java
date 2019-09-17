package com.epam.brest.summer.courses2019.model.stub;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ClientStubTest {

    private static final Integer CLIENT_ID = 1;
    private static final String CLIENT_NAME = "clientName";
    public static final Integer COUNT_OF_DEVICES = 11;

    ClientStub clientStub = new ClientStub();

    @Test
    public void getClientId() {
        clientStub.setClientId(CLIENT_ID);
        assertTrue(clientStub.getClientId().equals(CLIENT_ID));
    }

    @Test
    public void getClientName() {
        clientStub.setClientName(CLIENT_NAME);
        assertTrue(clientStub.getClientName().equals(CLIENT_NAME));
    }

    @Test
    public void getCountOfDevices() {
        clientStub.setcountOfDevices(COUNT_OF_DEVICES);
        assertTrue(clientStub.getcountOfDevices().equals(COUNT_OF_DEVICES));
    }

    @Test
    public void testToString() {
        clientStub.setClientId(CLIENT_ID);
        clientStub.setClientName(CLIENT_NAME);
        clientStub.setcountOfDevices(COUNT_OF_DEVICES);
        String expectedResponseClient = "Client{"
                + "clientId=" + CLIENT_ID
                + ", clientName='" + CLIENT_NAME + '\''
                + ", countOfDevices=" + COUNT_OF_DEVICES
                + '}';
    }
}