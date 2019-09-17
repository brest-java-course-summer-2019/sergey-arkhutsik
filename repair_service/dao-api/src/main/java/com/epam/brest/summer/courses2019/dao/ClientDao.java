package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Client;

import java.util.List;
import java.util.Optional;

/**
 * Client DAO Interface.
 */
public interface ClientDao {

    /**
     * Persist new client.
     *
     * @param client new client
     * @return new client object.
     */
    Client add(Client client);

    /**
     * Update client.
     *
     * @param client client
     */
    void update(Client client);

    /**
     * Delete client with specified id.
     *
     * @param clientId client id
     */
    void delete(Integer clientId);

    /**
     * Get clients.
     *
     * @return clients list.
     */
    List<Client> findAll();

    /**
     * Get Client By Id.
     *
     * @param clientId clientId
     * @return Client
     */
    Optional<Client> findById(Integer clientId);

}
