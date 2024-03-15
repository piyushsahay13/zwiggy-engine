package com.zwiggy.zwiggyengine.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * BranchDetailsEntity is an entity class representing details of a branch, including its location, supervisor information,
 * FSSAI license number, and the associated restaurant menu.
 *
 * @author piyush
 */
@Data
public class BranchDetailsEntity {

    /**
     * The door number of the branch.
     *
     * @Field("DoorNumber")
     */
    private String doorno;

    /**
     * The street name of the branch's location.
     *
     * @Field("Street")
     */
    private String street;

    /**
     * The city where the branch is located.
     *
     * @Field("City")
     */
    private String city;

    /**
     * The state where the branch is located.
     *
     * @Field("State")
     */
    private String state;

    /**
     * The pin code of the branch's location.
     *
     * @Field("Pincode")
     */
    private String pincode;

    /**
     * The Google Map location of the branch.
     *
     * @Field("GoogleMapLoc")
     */
    private String googleMapLoc;

    /**
     * The name of the supervisor managing the branch.
     *
     * @Field("SupervisorName")
     */
    private String supName;

    /**
     * The contact information of the supervisor managing the branch.
     *
     * @Field("SupervisorContact")
     */
    private String supContact;

    /**
     * The FSSAI license number associated with the branch.
     *
     * @Field("FSSAILicenceNo")
     */
    private String licNo;

    /**
     * The restaurant menu associated with the branch.
     *
     * @Field("RestaurantMenu")
     */
    private List<FoodMenuEntity> restaurantMenu;

}
