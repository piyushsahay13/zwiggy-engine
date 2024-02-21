package com.zwiggy.zwiggyengine.util;

import com.zwiggy.zwiggyengine.constant.RegexConstanst;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author piyush
 * Common utility class to perform opertaion of fields
 */
@Slf4j
public class CommonUtility {
    private CommonUtility() {
        throw new IllegalStateException("Utility class");
    }
    public static boolean isNumeric(String str) {
        return str != null && str.matches(RegexConstanst.ONLYNUMREGEX);
    }

    public static List<Double> geolocConverter(String geoloc) {

        String[] coordinates = geoloc.split(",");

        List<Double> res  = Arrays.stream(coordinates)
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        log.info("Longitude & Latitude : ", res.get(0)  + "" + res.get(1));
        return res;
    }

    public static boolean isValidLongitude(Double lon) {
        try {
            return lon >= -180 && lon <= 180;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidLatitude(Double lat) {
        try {
            return lat >= -90 && lat <= 90;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
