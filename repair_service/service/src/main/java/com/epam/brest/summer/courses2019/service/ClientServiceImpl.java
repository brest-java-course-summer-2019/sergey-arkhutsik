package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.dao.ClientDao;
import com.epam.brest.summer.courses2019.dao.ClientStubDao;
import com.epam.brest.summer.courses2019.model.Client;

import java.util.List;

import com.epam.brest.summer.courses2019.model.stub.ClientStub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Client Service Interface implementation.
 */
@Service
@Component
@Transactional
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    private ClientDao clientDao;

    private ClientStubDao clientStubDao;

    public ClientServiceImpl(ClientDao clientDao, ClientStubDao clientStubDao) {
        this.clientDao = clientDao;
        this.clientStubDao = clientStubDao;
    }

    @Override
    public List<Client> findAll()
        throws DataAccessException {
        LOGGER.debug("Find all clients");
        return clientDao.findAll();
    }

    @Override
    public List<ClientStub> findAllWithDevices()
        throws DataAccessException {
        LOGGER.debug("Find all clients with devices");
        return clientStubDao.findAllWithDevices();
    }

    @Override
    public Client findById(Integer id)
        throws DataAccessException {
        LOGGER.debug("findById({})", id);
        return clientDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to get client from DB"));
    }

    @Override
    public void update(Client client)
        throws DataAccessException {
        LOGGER.debug("update({})", client);
        clientDao.update(client);
    }

    @Override
    public void delete(int id)
        throws DataAccessException {
        LOGGER.debug("delete({})", id);
        clientDao.delete(id);
    }

    @Override
    public Client add(Client client)
        throws DataAccessException {
        return clientDao.add(client);
    }
}
