package com.epam.brest.summer.courses2019.web_app.validators;

import com.epam.brest.summer.courses2019.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClientValidator implements Validator {

    public static final int CLIENT_NAME_MAX_SIZE = 255;

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "clientName", "clientName.empty");
        Client client = (Client) target;

        if (StringUtils.hasLength(client.getClientName())
                && client.getClientName().length() > CLIENT_NAME_MAX_SIZE) {
            errors.rejectValue("clientName", "clientName.maxSize255");
        }
    }
}
