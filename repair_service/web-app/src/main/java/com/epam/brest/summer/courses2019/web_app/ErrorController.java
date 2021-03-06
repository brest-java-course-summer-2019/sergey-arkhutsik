package com.epam.brest.summer.courses2019.web_app;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller for errors.
 */
@ControllerAdvice
public class ErrorController extends RuntimeException {

    /**
     * Handling exception.
     * @param exc type of exception.
     * @param model model of data.
     * @return url path.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptionHandler(Exception exc, Model model) {
        model.addAttribute("errorMessage", exc.toString());
        return "error";
    }
}
