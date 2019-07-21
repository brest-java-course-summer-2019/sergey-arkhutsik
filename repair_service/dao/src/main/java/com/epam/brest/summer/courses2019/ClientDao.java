package com.epam.brest.summer.courses2019;

import com.epam.brest.summer.courses2019.model.Client;
import java.util.List;

public interface ClientDao {
    Client add(Client client);

    void update(Client client);

    void delete(Integer clientId);

    List<Client> findAll();

}
