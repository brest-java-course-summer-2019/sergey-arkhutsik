package com.epam.brest.summer.courses2019.web_app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class DeviceController {
    @GetMapping(value = "/devices")
    public final String getDevices(Model model) {
        return "devices";
    }
}
