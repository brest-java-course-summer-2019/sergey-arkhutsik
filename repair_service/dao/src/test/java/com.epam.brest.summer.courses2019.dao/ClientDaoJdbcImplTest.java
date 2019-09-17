package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:dao-test.xml"})
@Rollback
public class ClientDaoJdbcImplTest {

    @Autowired
    private ClientDao clientDao;

    @Test
    public void testAddClient() {
        int sizeBeforeAdd = clientDao.findAll().size();
        Client testAddClient = new Client();
        testAddClient.setClientName("test_client");
        Client newClient = clientDao.add(testAddClient);
        int sizeAfterAdd = clientDao.findAll().size();
        assertNotNull(newClient.getClientId());
        assertEquals(sizeBeforeAdd + 1, sizeAfterAdd);
    }

    @Test
    public void testUpdateClient() {
        Client testNewClient = new Client("test_client");
        clientDao.add(testNewClient);
        testNewClient.setClientName("new_test_client");
        clientDao.update(testNewClient);
        Client testUpdateClient = clientDao.findById(testNewClient.getClientId()).get();
        assertEquals(testNewClient.getClientId(), testUpdateClient.getClientId());
        assertEquals(testNewClient.getClientName(), testUpdateClient.getClientName());
    }

    @Test
    public void testDeleteClient() {
        Client testNewClient = new Client("test_client");
        clientDao.add(testNewClient);
        int sizeBeforeDelete = clientDao.findAll().size();
        clientDao.delete(testNewClient.getClientId());
        int sizeAfterDelete = clientDao.findAll().size();
        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
    }

    @Test
    public void testFindAllClients() {
        List<Client> clients = clientDao.findAll();
        assertNotNull(clients);
        assertTrue(clients.size() > 0);
    }

    @Test
    public void testFindClientById() {
        Client testFindClientById = clientDao.findById(1).get();
        assertNotNull(testFindClientById);
        assertTrue(testFindClientById.getClientId().equals(1));
        assertEquals(testFindClientById.getClientName(), "Иванов Иван Иванович");
    }

}
