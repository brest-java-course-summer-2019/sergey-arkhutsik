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
/**
 *  Device DAO Interface implementation.
 */
public class DeviceDaoJdbcImpl implements DeviceDao{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SELECT_ALL =
            "select d.device_id, d.device_model from device d order by 2";

    private static final String FIND_BY_ID =
            "select device_id, device_model from device where device_id = :deviceId";

    private final static String ADD_DEVICE =
            "insert into device (device_model) values (:deviceModel)";

    private static final String UPDATE =
            "update device set device_model = :deviceModel where device_id = :deviceId";

    private static final String DELETE =
            "delete from device where device_id = :deviceId";

    private static final String DEVICE_ID = "deviceId";

    public DeviceDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Device add(Device device) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("deviceModel", device.getDeviceModel());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(ADD_DEVICE, parameters, generatedKeyHolder);
        device.setDeviceId(generatedKeyHolder.getKey().intValue());
        return device;
    }

    @Override
    public void update(Device device) {
        Optional.of(namedParameterJdbcTemplate.update(UPDATE, new BeanPropertySqlParameterSource(device)))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Failed to update device in DB"));
    }

    private boolean successfullyUpdated(int numRowsUpdated) {
        return numRowsUpdated > 0;
    }

    @Override
    public void delete(Integer deviceId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(DEVICE_ID, deviceId);
        Optional.of(namedParameterJdbcTemplate.update(DELETE, mapSqlParameterSource))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Failed to delete device from DB"));
    }

    @Override
    public List<Device> findAll() {
        List<Device> devices = namedParameterJdbcTemplate.query(SELECT_ALL, new DeviceRowMapper());
        return devices;
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
