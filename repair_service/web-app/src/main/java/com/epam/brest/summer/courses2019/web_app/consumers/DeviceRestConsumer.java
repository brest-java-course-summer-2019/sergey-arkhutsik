package com.epam.brest.summer.courses2019.web_app.consumers;


import com.epam.brest.summer.courses2019.model.Device;
import com.epam.brest.summer.courses2019.service.DeviceService;
import com.epam.brest.summer.courses2019.web_app.ServerDataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

public class DeviceRestConsumer implements DeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceRestConsumer.class);

    private String url;

    private RestTemplate restTemplate;

    public DeviceRestConsumer(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Device> findAll() {
        LOGGER.debug("Find all devices");
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        return (List<Device>) responseEntity.getBody();
    }

    @Override
    public Device findById(Integer id) {
        LOGGER.debug("findById({})", id);
        ResponseEntity<Device> responseEntity1 = restTemplate.getForEntity(url + "/" + id, Device.class);
        return responseEntity1.getBody();
    }

    @Override
    public void update(Device device) {
        LOGGER.debug("update({})", device);
        restTemplate.put(url, device);
    }

    @Override
    public void delete(int id) {
        LOGGER.debug("delete({})", id);
        restTemplate.delete(url + "/" + id);
    }

    @Override
    public Device addDevice(Device device) {
        LOGGER.debug("add({})", device);
        ResponseEntity responseEntity = restTemplate.postForEntity(url, device, Device.class);
        Object result = responseEntity.getBody();
        return (Device) result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Device> filterDeviceByDate(Date fromDate, Date toDate)
            throws ServerDataAccessException {
        LOGGER.debug("REST-client filterDeviceByDate({} - {})", fromDate, toDate);
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url + "/" + fromDate + "/" + toDate, List.class);
        LOGGER.debug("REST-client filterDeviceByDate responseEntity({})", responseEntity);
        return (List<Device>) responseEntity.getBody();
    }

}