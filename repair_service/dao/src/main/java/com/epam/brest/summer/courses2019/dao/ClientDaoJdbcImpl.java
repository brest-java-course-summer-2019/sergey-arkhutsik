package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Client DAO Interface implementation.
 */
@Component
public class ClientDaoJdbcImpl implements ClientDao {

    /**
     * NamedParameterJdbcTemplate.
     */
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * SQL query for select all clients.
     */
    @Value("${client.findAll}")
    private String findAllSql;

    /**
     * SQL query for select client by id.
     */
    @Value("${client.findById}")
    private String findByIdSql;

    /**
     * SQL query for insert client.
     */
    @Value("${client.insert}")
    private String insertSql;

    /**
     * SQL query for update client.
     */
    @Value("${client.update}")
    private String updateSql;

    /**
     * SQL query for delete client.
     */
    @Value("${client.delete}")
    private String deleteSql;

    /**
     * Column name in client table DB.
     */
    private static final String CLIENT_ID = "clientId";

    public ClientDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Client add(Client client) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("clientName", client.getClientName());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insertSql, parameters, generatedKeyHolder);
        client.setClientId(generatedKeyHolder.getKey().intValue());
        return client;
    }

    @Override
    public void update(Client client) {
        if (namedParameterJdbcTemplate.update(updateSql, new BeanPropertySqlParameterSource(client)) < 1) {
            throw new EmptyResultDataAccessException(
                    String.format("Failed to update. '%s' not found in the DB", client), 1);
        }
    }

    @Override
    public void delete(Integer clientId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(CLIENT_ID, clientId);
        if (namedParameterJdbcTemplate.update(deleteSql, mapSqlParameterSource) < 1) {
            throw new RuntimeException("Failed to delete client from DB");
        }
//        Optional.of(namedParameterJdbcTemplate.update(deleteSql, mapSqlParameterSource))
//                .filter(this::successfullyUpdated)
//                .orElseThrow(() -> new RuntimeException("Failed to delete client from DB"));
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = namedParameterJdbcTemplate.query(findAllSql, new ClientRowMapper());
        return clients;
    }

    @Override
    public Optional<Client> findById(Integer clientId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(CLIENT_ID, clientId);
        List<Client> results = namedParameterJdbcTemplate.query(findByIdSql, namedParameters,
                BeanPropertyRowMapper.newInstance(Client.class));
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    private class ClientRowMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            Client client = new Client();
            client.setClientId(resultSet.getInt("client_id"));
            client.setClientName(resultSet.getString("client_name"));
            return client;
        }
    }

}
