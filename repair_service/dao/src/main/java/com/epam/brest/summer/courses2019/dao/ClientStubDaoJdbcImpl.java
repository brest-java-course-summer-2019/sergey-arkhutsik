package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.stub.ClientStub;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClientStub DAO Interface implementation.
 */
@Component
public class ClientStubDaoJdbcImpl implements ClientStubDao {

    /**
     * NamedParameterJdbcTemplate.
     */
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * SQL query for find all clients with devices.
     */
    @Value("${clientStub.findAllWithDevices}")
    private String findAllWithDevicesSql;


    public ClientStubDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<ClientStub> findAllWithDevices() {
        List<ClientStub> clients = namedParameterJdbcTemplate.query(findAllWithDevicesSql,
                BeanPropertyRowMapper.newInstance(ClientStub.class));
        return clients;
    }

}
