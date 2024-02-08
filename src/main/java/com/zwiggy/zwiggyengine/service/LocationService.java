package com.zwiggy.zwiggyengine.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.exception.UserValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Value("${google.maps.apiKey}")
    private String googleMapsApiKey;

    public boolean validateLocation(double latitude, double longitude) throws UserValidationException {
        try {
            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey(googleMapsApiKey)
                    .build();
            LatLng geoLoc = new LatLng(latitude,longitude);
            GeocodingResult[] results = GeocodingApi.reverseGeocode(context, geoLoc).await();
            return results.length > 0;

        } catch (Exception e) {
            throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.GEOLOCERROR));
        }
    }
}
