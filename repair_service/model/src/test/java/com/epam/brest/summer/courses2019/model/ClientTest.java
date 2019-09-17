package com.epam.brest.summer.courses2019.model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ClientTest {

    private static final Integer CLIENT_ID = 1;
    private static final String CLIENT_NAME = "clientName";

    Client client = new Client();

    @Test
    public void getClientId() {
        client.setClientId(CLIENT_ID);
        assertTrue(client.getClientId().equals(CLIENT_ID));
    }

    @Test
    public void getClientName() {
        client.setClientName(CLIENT_NAME);
        assertTrue(client.getClientName().equals(CLIENT_NAME));
    }

    /**
     * Constructor Client Test
     */
    public ClientTest() {
        Client client = new Client(CLIENT_NAME);
        assertEquals(client.getClientName(), CLIENT_NAME);
    }

    @Test
    public void testToString() {
        client.setClientId(CLIENT_ID);
        client.setClientName(CLIENT_NAME);
        String expectedResponseClient = "Client{"
                + "clientId=" + CLIENT_ID
                + ", clientName='" + CLIENT_NAME + '\''
                + '}';
    }
}
