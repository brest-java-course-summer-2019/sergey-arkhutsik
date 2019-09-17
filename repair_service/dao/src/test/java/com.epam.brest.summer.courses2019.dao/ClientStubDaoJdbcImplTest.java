package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.stub.ClientStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
@Rollback
public class ClientStubDaoJdbcImplTest {

    @Autowired
    private ClientStubDao clientStubDao;

    @Test
    public void testFindAllClientsWithDevices() {
        List<ClientStub> clients = clientStubDao.findAllWithDevices();
        assertNotNull(clients);
        assertTrue(clients.size() > 0);
    }

}
