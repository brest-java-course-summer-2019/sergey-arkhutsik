package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientDao {

    Client add(Client client);

    void update(Client client);

    void delete(Integer clientId);

    List<Client> findAll();

    Optional<Client> findById(Integer clientId);

}