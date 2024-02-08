package com.zwiggy.zwiggyengine.util;

import com.zwiggy.zwiggyengine.constant.RegexConstanst;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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
        List<Double> res = new ArrayList<>();
        for (String s : geoloc.replace(" ", "").split(",")) {
            res.add(Double.parseDouble(s));
        }
        log.info("Longitude & Latitude : ", res);
        return res;
    }



}
