package com.epam.brest.summer.courses2019.service;

import com.epam.brest.summer.courses2019.model.Client;
import com.epam.brest.summer.courses2019.model.stub.ClientStub;

import java.util.List;

/**
 * Client Service Interface.
 */
public interface ClientService {

    /**
     * Find all clients stream.
     *
     * @return clients .
     */
    List<Client> findAll();

    /**
     * Get all clients with avg salary by client.
     *
     * @return clients list.
     */
    List<ClientStub> findAllWithDevices();

    /**
     * Find Client By Id.
     *
     * @param id id
     * @return Client
     */
    Client findById(Integer id);

    /**
     * Update client.
     *
     * @param client client
     */
    void update(Client client);

    /**
     * Delete Client.
     *
     * @param id client id
     */
    void delete(int id);


    Client add(Client client);
}
