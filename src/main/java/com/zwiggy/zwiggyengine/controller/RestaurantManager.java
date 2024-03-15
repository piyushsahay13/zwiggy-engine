package com.zwiggy.zwiggyengine.controller;

import com.zwiggy.zwiggyengine.model.RestaurantResponse;
import com.zwiggy.zwiggyengine.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.constraints.NotEmpty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("Restaurant manager apis")
@RequestMapping(value = "/restaurant")
@Slf4j
@Validated
public class RestaurantManager {

    @Autowired
    private CommonService restaurantService;

    @ApiOperation(value = "Get registered restaurants for userid", notes = "This endpoint returns all restaurants information associated userid.")
    @GetMapping(value = "/getRestaurants", produces = "application/json")
    public ResponseEntity<RestaurantResponse> fetchRestaurantDetails(@RequestParam(name = "userid") String userid,
                                                                     @RequestParam(name = "restauarntid",required = false) String restaurantid) {
        RestaurantResponse response = restaurantService.getRestaurantsDetails(userid, restaurantid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
