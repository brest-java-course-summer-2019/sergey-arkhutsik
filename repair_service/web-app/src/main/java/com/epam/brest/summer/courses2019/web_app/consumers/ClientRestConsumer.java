package com.epam.brest.summer.courses2019.web_app.consumers;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.model.stub.ClientStub;
import com.epam.brest.summer.courses2019.service.ClientService;
import com.epam.brest.summer.courses2019.web_app.ServerDataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ClientRestConsumer implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRestConsumer.class);

    private String url;

    private RestTemplate restTemplate;

    public ClientRestConsumer(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Client> findAll()
        throws ServerDataAccessException {
        LOGGER.debug("Find all clients");
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        return (List<Client>) responseEntity.getBody();
    }

    @Override
    public List<ClientStub> findAllWithDevices()
        throws ServerDataAccessException {
        LOGGER.debug("findAllWithDevices()");
        ResponseEntity responseEntity = restTemplate.getForEntity(url + "/with_devices", List.class);
        return (List<ClientStub>) responseEntity.getBody();
    }

    @Override
    public Client findById(Integer id)
        throws ServerDataAccessException {
        LOGGER.debug("findById({})", id);
        ResponseEntity<Client> responseEntity = restTemplate.getForEntity(url + "/" + id, Client.class);
        return responseEntity.getBody();
    }

    @Override
    public void update(Client client)
        throws ServerDataAccessException {
        LOGGER.debug("update({})", client);
        restTemplate.put(url, client);
    }

    @Override
    public void delete(int id)
        throws ServerDataAccessException {
        LOGGER.debug("delete({})", id);
        restTemplate.delete(url + "/" + id);
    }

    @Override
    public Client add(Client client)
        throws ServerDataAccessException {
        LOGGER.debug("add({})", client);
        ResponseEntity responseEntity = restTemplate.postForEntity(url, client, Client.class);
        Object result = responseEntity.getBody();
        return (Client) result;
    }
}
