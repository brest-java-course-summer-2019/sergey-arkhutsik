package com.epam.brest.summer.courses2019.web_app;

import com.epam.brest.summer.courses2019.model.Device;
import com.epam.brest.summer.courses2019.service.ClientService;
import com.epam.brest.summer.courses2019.service.DeviceService;
import com.epam.brest.summer.courses2019.web_app.validators.DeviceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Device controller.
 */
@Controller
public class DeviceController {

    /**
     * Logger for Device controller.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);

    /**
     * Service of device.
     */
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ClientService clientService;

    @Autowired
    DeviceValidator deviceValidator;

    /**
     * Goto devices list page.
     *
     * @param model model
     * @return view name
     */
    @GetMapping(value = "/devices")
    public final String devices(Model model) {
        LOGGER.debug("findAll({})", model);
        model.addAttribute("devices", deviceService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "devices";
    }

    /**
     * Goto edit device page.
     *
     * @return view name
     */
    @GetMapping(value = "/device/{id}")
    public final String gotoEditDevicePage(@PathVariable int id, Model model) {
        LOGGER.debug("gotoEditDevicePage({},{})", id, model);
        model.addAttribute("device", deviceService.findById(id));
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("isNew", false);
        return "device";
    }

    /**
     * Update device into persistence storage.
     *
     * @return view name
     */
    @PostMapping(value = "/device/{id}")
    public String updateDevice(@Valid Device device, BindingResult result, Model model) {
        LOGGER.debug("updateDevice({}, {})", device, result);
        deviceValidator.validate(device, result);
        if (result.hasErrors()) {
            model.addAttribute("device", device);
            model.addAttribute("clients", clientService.findAll());
            model.addAttribute("isNew", false);
            return "device";
        } else {
            this.deviceService.update(device);
            return "redirect:/devices";
        }
    }

    /**
     * Goto add device page.
     *
     * @return view name
     */
    @GetMapping(value = "/device")
    public final String gotoAddDevicePage(Model model) {
        LOGGER.debug("gotoAddDevicePage({})", model);
        Device device = new Device();
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("isNew", true);
        model.addAttribute("device", device);
        return "device";
    }

    @PostMapping(value = "/device")
    public String addDevice(@Valid Device deviceAdd, BindingResult result, Model model) throws Exception {
        LOGGER.debug("postAddDevice({}, {})", deviceAdd, result);
        deviceValidator.validate(deviceAdd, result);
        if (result.hasErrors()) {
            model.addAttribute("clients", clientService.findAll());
            model.addAttribute("device", deviceAdd);
            model.addAttribute("isNew", true);
            return "device";
        } else {
            deviceService.addDevice(deviceAdd);
            return "redirect:/devices";
        }
    }

    /**
     * Delete device.
     *
     * @return view name
     */
    @GetMapping(value = "/device/{id}/delete")
    public final String deleteDeviceById(@PathVariable Integer id, Model model) {
        LOGGER.debug("delete({},{})", id, model);
        deviceService.delete(id);
        return "redirect:/devices";
    }

    /**
     * Get devices by dates.
     * @param fromDate - start date.
     * @param toDate - end date.
     * @param model - model of data.
     * @return - path.
     * @throws ParseException - exception of parsing date.
     */
    @GetMapping(value = "/devices/{fromDate}/{toDate}")
    public String filterDeviceByDate(@PathVariable String fromDate, @PathVariable String toDate, Model model)
            throws ParseException {
        LOGGER.debug("filterDeviceByDate({} - {})", fromDate, toDate);
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date startDate = formatDate.parse(fromDate);
        Date endDate = formatDate.parse(toDate);
        model.addAttribute("devices", deviceService.filterDeviceByDate(startDate, endDate));
        return "devices";
    }

}
