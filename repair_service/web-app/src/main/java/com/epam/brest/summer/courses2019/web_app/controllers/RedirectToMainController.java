package com.epam.brest.summer.courses2019.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Redirect MVC controller.
 */


@Controller
public class RedirectToMainController {

    @GetMapping("/")
    public final String toDevicePageRedirect() {
        return "devices";
    }
}
