package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.stub.ClientStub;

import java.util.List;

/**
 * ClientStub DAO Interface.
 */
public interface ClientStubDao {

    /**
     * Get all clients with avg salary by client.
     *
     * @return clients list.
     */
    List<ClientStub> findAllWithDevices();

}
