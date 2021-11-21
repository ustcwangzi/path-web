package com.path.web.utils;

import com.path.web.request.AddPathRequest;
import org.apache.commons.lang3.Validate;

public class ValidationUtils {
    public static void valid(AddPathRequest request) {
        Validate.notNull(request, "request is null");
        Validate.isTrue(request.getSourceCity() != null && request.getSourceCity() > 0, "sourceCity invalid");
        Validate.isTrue(request.getDestinyCity() != null && request.getDestinyCity() > 0, "destinyCity invalid");
        Validate.isTrue(request.getDepartureTime() != null && request.getDepartureTime() >= 0, "departureTime invalid");
        Validate.isTrue(request.getArriveTime() != null && request.getArriveTime() > request.getDepartureTime(), "arriveTime invalid");
    }
}
