package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Client;
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

@Component
public class ClientDaoJdbcImpl implements ClientDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SELECT_ALL =
            "select c.client_id, c.client_name from client c order by client_name";

    private static final String FIND_BY_ID =
            "select client_id, client_name FROM client where client_id = :clientId";

    private final static String ADD_CLIENT =
            "insert into client (client_name) values (:clientName)";

    private final static String UPDATE_CLIENT =
            "update client set client_name = :clientName where client_id = :clientId";

    private final static String DELETE_CLIENT =
            "delete from client where client_id = :clientId";

    private static final String CLIENT_ID = "clientId";

    public ClientDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Client add(Client client) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("clientName", client.getClientName());
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(ADD_CLIENT, parameters, generatedKeyHolder);
        client.setClientId(generatedKeyHolder.getKey().intValue());
        return client;
    }

    @Override
    public void update(Client client) {
        Optional.of(namedParameterJdbcTemplate.update(UPDATE_CLIENT, new BeanPropertySqlParameterSource(client)))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Error updating client in Database!"));
    }

    private boolean successfullyUpdated(int numRowsUpdated) {
        return numRowsUpdated > 0;
    }

    @Override
    public void delete(Integer clientId) {
        MapSqlParameterSource deleteParameter = new MapSqlParameterSource();
        deleteParameter.addValue(CLIENT_ID, clientId);
        Optional.of(namedParameterJdbcTemplate.update(DELETE_CLIENT, deleteParameter))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Error deleting department from Database!"));
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients =
                namedParameterJdbcTemplate.query(SELECT_ALL, new ClientRowMapper());
        return clients;
    }

    @Override
    public Optional<Client> findById(Integer clientId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(CLIENT_ID, clientId);
        List<Client> results = namedParameterJdbcTemplate.query(FIND_BY_ID, namedParameters,
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
