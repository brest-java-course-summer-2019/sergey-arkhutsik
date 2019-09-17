package com.epam.brest.summer.courses2019.web_app.validators;

import com.epam.brest.summer.courses2019.model.Device;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DeviceValidator implements Validator {

    public static final int DEVICE_NAME_MAX_SIZE = 255;
    public static final int DEVICE_DESCRIPTION_MAX_SIZE = 255;

    @Override
    public boolean supports(Class<?> clazz) {
        return Device.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "deviceName", "deviceName.empty");
        ValidationUtils.rejectIfEmpty(errors, "deviceDescription", "deviceDescription.empty");
        Device device = (Device) target;

        if (StringUtils.hasLength(device.getDeviceName())
                && device.getDeviceName().length() > DEVICE_NAME_MAX_SIZE) {
            errors.rejectValue("deviceName", "deviceName.maxSize255");
        }

        if (StringUtils.hasLength(device.getDeviceDescription())
                && device.getDeviceDescription().length() > DEVICE_DESCRIPTION_MAX_SIZE) {
            errors.rejectValue("deviceDescription", "deviceDescription.maxSize255");
        }
    }
}
