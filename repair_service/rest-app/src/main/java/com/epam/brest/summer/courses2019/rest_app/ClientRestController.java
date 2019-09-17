package com.epam.brest.summer.courses2019.rest_app;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.model.stub.ClientStub;
import com.epam.brest.summer.courses2019.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRestController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients")
    public List<Client> findAll() {
        LOGGER.debug("get all clients");
        return clientService.findAll();
    }

    @GetMapping(value = "/clients/with_devices")
    public List<ClientStub> findAllStubs() {
        LOGGER.debug("get all clients stubs");
        return clientService.findAllWithDevices();
    }

    @GetMapping(value = "/clients/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Client findById(@PathVariable Integer id) {
        LOGGER.debug("find client by id({})", id);
        return clientService.findById(id);
    }

    @PutMapping(value = "/clients")
    public final void update(@RequestBody final Client client) {
        LOGGER.debug("update client ({})", client);
        clientService.update(client);
    }

    @DeleteMapping(value = "/clients/{id}")
    public void delete(@PathVariable("id") int id) {
        LOGGER.debug("delete client ({})", id);
        clientService.delete(id);
    }

    @PostMapping(value = "/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public final Client add(@RequestBody final Client client) {
        LOGGER.debug("add client({})", client);
        return clientService.add(client);
    }

}