package com.zwiggy.zwiggyengine.service;

import com.zwiggy.zwiggyengine.constant.AppConstant;
import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.entity.*;
import com.zwiggy.zwiggyengine.exception.InvalidUserException;
import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;
import com.zwiggy.zwiggyengine.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommonService {

    @Autowired
    private UserRepoServiceImpl userRepoService;

    @Autowired
    private RestaurantRepoServiceImpl restRepoService;

    @Autowired
    private MenuRepoServiceImpl menuRepoService;

    public GenericResponse addNewCustomer(Customer userDetails) throws InvalidUserException, RepositoryOperationException {
        if(!userRepoService.userExist(userDetails.getEmail())) {
            UserAccountEntity user = new UserAccountEntity();
            user.setEmail(userDetails.getEmail());
            user.setAddress(userDetails.getAddress().get(0).toString());
            user.setFname(userDetails.getFName());
            user.setLname(userDetails.getSName());
            user.setContactNumber(userDetails.getContactNo());
            user.setUsertype(UserType.getCodefrmUsrType(userDetails.getUserType()));
            user.setUserCreationDate(getTodaysDate());
            return GenericResponse.builder()
                    .responseMsg(AppConstant.EMAIL_VERIFY)
                    .respType(AppConstant.SUCCESS)
                    .emailId(userRepoService.addNewEntry(user)  + AppConstant.USERADDED)
                    .build();
        }
        else {
            throw new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USEREXIST));
        }
    }
    public GenericResponse addNewRestaurant(Restaurant restaurantDetails) throws InvalidUserException, RepositoryOperationException {
        UserAccountEntity user = new UserAccountEntity();
        user.setEmail(restaurantDetails.getEmail());
        user.setAddress(restaurantDetails.getAddress().get(0).toString());
        user.setFname(restaurantDetails.getFName());
        user.setLname(restaurantDetails.getSName());
        user.setContactNumber(restaurantDetails.getContactNo());
        if(userRepoService.userExist(restaurantDetails.getEmail())) {
            user.setUsertype(UserType.getCodefrmUsrType(UserType.USER_RESTAURANT));
        }
        else {
            user.setUsertype(UserType.getCodefrmUsrType(restaurantDetails.getUserType()));
        }
        user.setUserCreationDate(getTodaysDate());
        UUID id = UUID.randomUUID();
        log.info("Restaurant Id Created : "+id.toString());
        RestaurantsEntity restDetails = new RestaurantsEntity();
        restDetails.setRestaurantId(id.toString());
        restDetails.setEmailId(restaurantDetails.getEmail());
        restDetails.setRestaurantName(restaurantDetails.getRestaurantName());
        restDetails.setIsPureVeg('N');
        restDetails.setAvgRating((double) restaurantDetails.getAvgRating());
        restDetails.setCity(restaurantDetails.getAddress().get(0).getCity());
        String username = userRepoService.addNewEntry(user);
        log.info("User added Success.");
        String restid = restRepoService.addNewEntry(restDetails);
        log.info("Restaurant Creation Success.");
        setupRestaurantMenu(restaurantDetails, restid);
        log.info("Restauarnt Menu Added.");
        return GenericResponse.builder()
                .responseMsg(AppConstant.EMAIL_VERIFY)
                .respType(AppConstant.SUCCESS)
                .restId(restid)
                .emailId(username + AppConstant.USERADDED)
                .build();
    }
    public Customer getCustomerDetailfromId(Optional<String> userid) throws InvalidUserException, RepositoryOperationException {
        String userIdToString = userid.orElseThrow(() -> new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERIDERROR)));
        UserAccountEntity response = (UserAccountEntity) userRepoService.fetchExistingData(userIdToString);
        List<Address> address = new ArrayList<>();
        return Customer.customerBuilder()
                .fName(response.getFname())
                .sName(response.getLname())
                .email(response.getEmail())
                .contactNo(response.getContactNumber())
                .address(address)
                .userType(UserType.getCodeUsrType(response.getUsertype()))
                .longitudeLatitude(null)
                .cstmrFeedback(null)
                .orderHistory(null)
                .cart(null)
                .build();
    }
    public void setupRestaurantMenu(Restaurant restaurantDetails, String restid) {
        log.info("Restaurant Onboarding started.");
        BranchEntity branchEntity = new BranchEntity();
        branchEntity.setRestName(restaurantDetails.getRestaurantName());
        branchEntity.setEmailId(restaurantDetails.getEmail());
        branchEntity.setTimeStamp(getTodaysDate());
        branchEntity.setRestaurantId(restid);
        branchEntity.setRestaurants(mapRestDetailsToBranchEntities(restaurantDetails.getRestDetails()));
        log.info("Branch Details : "+ branchEntity.toString());
        menuRepoService.addNewEntry(branchEntity);
    }

    public RestaurantResponse getRestaurantsDetails(String userid, String restid) {
       BranchEntity menuresp = restid!=null ? (BranchEntity) menuRepoService.fetchExistingData(restid) : menuRepoService.fetchByemail(userid);
       return RestaurantResponse.builder()
               .restid(menuresp.getRestaurantId())

               .restName("test")
//               .restaurantsList(menuresp.getAddress())
               .count(menuresp.getRestaurantId().length())
               .build();

    }

    public List<BranchDetailsEntity> mapRestDetailsToBranchEntities(List<RestaurantDetail> restDetailsList) {
        return restDetailsList.stream()
                .map(this::mapRestDetailsToBranchEntity)
                .collect(Collectors.toList());
    }

    private BranchDetailsEntity mapRestDetailsToBranchEntity(RestaurantDetail restDetails) {
        BranchDetailsEntity branchEntity = new BranchDetailsEntity();
        branchEntity.setDoorno(restDetails.getDoorno());
        branchEntity.setStreet(restDetails.getStreet());
        branchEntity.setPincode(restDetails.getPincode());
        branchEntity.setCity(restDetails.getCity());
        branchEntity.setState(restDetails.getState());
        branchEntity.setGoogleMapLoc(restDetails.getGoogleMapLoc());
        branchEntity.setSupName(restDetails.getSupName());
        branchEntity.setLicNo(restDetails.getLicNo());
        branchEntity.setSupContact(restDetails.getSupContact());
        List<FoodMenuEntity> foodMenu = restDetails.getRestaurantMenu().stream()
                .map(this::mapRestMenuToFoodMenuEtity)
                .collect(Collectors.toList());
        branchEntity.setRestaurantMenu(foodMenu);
        return branchEntity;
    }

    private FoodMenuEntity mapRestMenuToFoodMenuEtity(FoodMenu restMenu) {
        FoodMenuEntity foodMenuEntity = new FoodMenuEntity();
        foodMenuEntity.setCusine(restMenu.getCusine());
        List<FoodItemsEntity> foodItem =restMenu.getFooditems().stream()
                .map(this::mapRestMenuToFoodItemsEntity)
                .collect(Collectors.toList());
        foodMenuEntity.setFoodItems(foodItem);
        return foodMenuEntity;
    }

    private FoodItemsEntity mapRestMenuToFoodItemsEntity(FoodItems foodItems) {
        FoodItemsEntity foodItemsEntity = new FoodItemsEntity();
        foodItemsEntity.setItemName(foodItems.getItemName());
        foodItemsEntity.setPrice(foodItems.getPrice());
        foodItemsEntity.setAvailaible(foodItems.isAvailaible());
        return foodItemsEntity;
    }
    public List<Address> amapRestMenuToFoodMenuEtityddressDeserializerService() {
        return Collections.emptyList();
    }

    public Date getTodaysDate() {
        return new java.util.Date();
    }


}
