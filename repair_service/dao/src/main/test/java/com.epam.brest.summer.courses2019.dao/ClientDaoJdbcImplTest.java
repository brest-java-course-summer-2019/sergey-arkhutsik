package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})

public class ClientDaoJdbcImplTest {

    private static final String CLIENT1 = "First Client";
    private static final String CLIENT2 = "Second client";
    private static final String NEW_CLIENT = "New Client";

    @Autowired
    ClientDao clientDao;

    @Test
    public void findAll() {
        List<Client> clients = clientDao.findAll();
        assertNotNull(clients);
        assertTrue(clients.size() > 0);
    }

    @Test
    public void getClientById() {
        Client testGetClientById = clientDao.findById(2).get();
        assertNotNull(testGetClientById);
        assertTrue(testGetClientById.getClientId().equals(2));
        assertEquals(testGetClientById.getClientName(), CLIENT1);
    }

    @Test
    public void addClient() {
        Client testAddClient = new Client(CLIENT2);
        testAddClient.setClientName("Иванов Ваня");
        Client newClient = clientDao.add(testAddClient);
        Assert.assertNotNull(newClient.getClientId());
    }

    @Test
    public void updateClient() {
        Client testNewClient = new Client(CLIENT2);
        testNewClient = clientDao.add(testNewClient);
        testNewClient.setClientName(NEW_CLIENT);
        clientDao.update(testNewClient);
        Client testUpdateClient = clientDao.findById(testNewClient.getClientId()).get();
        assertEquals(testNewClient.getClientId(), testNewClient.getClientId());
        assertEquals(testNewClient.getClientName(), testNewClient.getClientName());
    }

    @Test
    public void deleteClient() {
        Client testNewClient = new Client(CLIENT2);
        testNewClient = clientDao.add(testNewClient);

        List<Client> clients = clientDao.findAll();
        int sizeBefore = clients.size();
        clientDao.delete(testNewClient.getClientId());
        assertTrue((sizeBefore - 1) == clientDao.findAll().size());
    }
}
