package com.epam.brest.summer.courses2019.model;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {
    Client client = new Client();

    @Test
    public void getClientId(){
        client.setClientId(99);
        Assert.assertTrue(client.getClientId().equals(99));
    }

    @Test
    public void getClientName(){
        client.setClientName("Vovan");
        Assert.assertTrue(client.getClientName().equals("Vovan"));
    }
}
