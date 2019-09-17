package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.dao.ClientDao;
import com.epam.brest.summer.courses2019.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Client Service Interface implementation.
 */
@Service
@Component
@Transactional
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    private ClientDao clientDao;


    @Override
    public List<Client> findAll() {
        LOGGER.debug("Find all clients");
        return clientDao.findAll();
    }

    @Override
    public Client findById(Integer id) {
        LOGGER.debug("findById({})", id);
        return clientDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Failed to get client from DB"));
    }

    @Override
    public void update(Client client) {
        LOGGER.debug("update({})", client);
        clientDao.update(client);
    }

    @Override
    public void delete(int id) {
        LOGGER.debug("delete({})", id);
        clientDao.delete(id);
    }

    @Override
    public Client add(Client client) {
        return clientDao.add(client);
    }
}
