package com.epam.brest.summer.courses2019;

import com.epam.brest.summer.courses2019.model.Client;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ClientDaoJdbcImpl implements ClientDao{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SELECT_ALL =
            "select d.client_id, d.client_name from client d order by 2";

    private final static String ADD_CLIENT = "insert into client (client_name) values (:clientName)";

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

    }

    @Override
    public void delete(Integer clientId) {

    }

    @Override
    public List<Client> findAll() {
        List<Client> clients =
                namedParameterJdbcTemplate.query(SELECT_ALL, new ClientRowMapper());
        return clients;
    }

    private class ClientRowMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            Client department = new Client();
            department.setClientId(resultSet.getInt("client_id"));
            department.setClientName(resultSet.getString("client_name"));
            return department;
        }
    }

}
