package com.epam.brest.summer.courses2019.dao;

import com.epam.brest.summer.courses2019.model.Device;
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
public class DeviceDaoJdbcImpl implements DeviceDao{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SELECT_ALL =
            "select device_id, device_model, device_description, device_date,  " +
                    "client_id from device d order by device_id";

    private static final String FIND_BY_ID =
            "select device_id, device_model, device_description, device_date,  " +
                    "client_id from device where device_id = :deviceId";

    private static final String FIND_BY_CLIENT_ID =
            "SELECT device_id, device_model, device_description, device_date,  " +
                    "client_id from device where client_id = :clientId";

    private final static String ADD_DEVICE =
            "insert into device (device_model, device_description, device_date, " +
                    "client_id) values (:deviceModel, :deviceDescription, :deviceDate, :clientId)";

    private static final String UPDATE_DEVICE =
            "update device set device_model = :deviceModel, device_description = :deviceDescription, device_date = :deviceDate, client_id = :clientId where device_id = :deviceId";

    private static final String DELETE_DEVICE =
            "delete from device where device_id = :deviceId";

    private static final String DEVICE_ID = "deviceId";
    private static final String CLIENT_ID = "clientId";

    public DeviceDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Device add(Device device) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("deviceModel", device.getDeviceModel());
        parameters.addValue("deviceDescription", device.getDeviceDescription());
        parameters.addValue("deviceDate", device.getDeviceDate());
        parameters.addValue("clientId", device.getClientId());
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(ADD_DEVICE, parameters, generatedKeyHolder);
        device.setDeviceId(generatedKeyHolder.getKey().intValue());
        return device;
    }

    @Override
    public void update(Device device) {
        Optional.of(namedParameterJdbcTemplate.update(UPDATE_DEVICE, new BeanPropertySqlParameterSource(device)))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Error updaring device in DB"));
    }

    private boolean successfullyUpdated(int numRowsUpdated) {
        return numRowsUpdated > 0;
    }

    @Override
    public void delete(Integer deviceId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(DEVICE_ID, deviceId);
        Optional.of(namedParameterJdbcTemplate.update(DELETE_DEVICE, mapSqlParameterSource))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Error deleting device from DB"));
    }

    @Override
    public List<Device> findAll() {
        List<Device> devices = namedParameterJdbcTemplate.query(SELECT_ALL, new DeviceRowMapper());
        return devices;
    }

    @Override
    public List<Device> findByDeviceId(Integer clientId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(CLIENT_ID, clientId);
        List<Device> results = namedParameterJdbcTemplate.query(FIND_BY_CLIENT_ID, namedParameters,
                BeanPropertyRowMapper.newInstance(Device.class));
        return results;
    }

    @Override
    public Optional<Device> findById(Integer deviceId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(DEVICE_ID, deviceId);
        List<Device> results = namedParameterJdbcTemplate.query(FIND_BY_ID, namedParameters,
                BeanPropertyRowMapper.newInstance(Device.class));
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    private class DeviceRowMapper implements RowMapper<Device> {
        @Override
        public Device mapRow(ResultSet resultSet, int i) throws SQLException {
            Device device = new Device();
            device.setDeviceId(resultSet.getInt("device_id"));
            device.setDeviceModel(resultSet.getString("device_name"));
            return device;
        }
    }

}
