package com.zwiggy.zwiggyengine.service;

import com.zwiggy.zwiggyengine.constant.AppConstant;
import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.entity.Menu;
import com.zwiggy.zwiggyengine.entity.Restaurants;
import com.zwiggy.zwiggyengine.entity.UserAccount;
import com.zwiggy.zwiggyengine.exception.InvalidUserException;
import com.zwiggy.zwiggyengine.exception.RepositoryOperationException;
import com.zwiggy.zwiggyengine.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CommonService {

    @Autowired
    private UserRepoServiceImpl userRepoService;

    @Autowired
    private RestaurantRepoServiceImpl restRepoService;

    @Autowired
    private MenuRepoServiceImpl menuRepoService;

    public Response addNewCustomer(Customer userDetails) throws InvalidUserException, RepositoryOperationException {
        if(!userRepoService.userExist(userDetails.getEmail())) {
            UserAccount user = new UserAccount();
            user.setEmail(userDetails.getEmail());
            user.setAddress(userDetails.getAddress().get(0).toString());
            user.setFname(userDetails.getFName());
            user.setLname(userDetails.getSName());
            user.setContactNumber(userDetails.getContactNo());
            user.setUsertype(UserType.getCodefrmUsrType(userDetails.getUserType()));
            user.setUserCreationDate(getTodaysDate());
            return Response.builder()
                    .responseMsg(AppConstant.EMAIL_VERIFY)
                    .respType(AppConstant.SUCCESS)
                    .emailId(userRepoService.addNewEntry(user) + AppConstant.USERADDED)
                    .build();
        }
        else {
            throw new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USEREXIST));
        }
    }
    public Response addNewRestaurant(Restaurant userDetails) throws InvalidUserException, RepositoryOperationException {
        UserAccount user = new UserAccount();
        user.setEmail(userDetails.getEmail());
        user.setAddress(userDetails.getAddress().get(0).toString());
        user.setFname(userDetails.getFName());
        user.setLname(userDetails.getSName());
        user.setContactNumber(userDetails.getContactNo());
        if(userRepoService.userExist(userDetails.getEmail())) {
            user.setUsertype(UserType.getCodefrmUsrType(UserType.USER_RESTAURANT));
        }
        else {
            user.setUsertype(UserType.getCodefrmUsrType(userDetails.getUserType()));
        }
        user.setUserCreationDate(getTodaysDate());
        UUID id = UUID.randomUUID();
        log.info("Restaurant Id Created : "+id.toString());
        Restaurants restDetails = new Restaurants();
        restDetails.setRestaurantId(id.toString());
        restDetails.setEmailId(userDetails.getEmail());
        restDetails.setRestaurantName(userDetails.getRestaurantName());
        restDetails.setIsPureVeg('N');
        restDetails.setAvgRating((double) userDetails.getAvgRating());
        restDetails.setCity(userDetails.getAddress().get(0).getCity());
        String username = userRepoService.addNewEntry(user);
        log.info("User added Success.");
        String restid = restRepoService.addNewEntry(restDetails);
        log.info("Restaurant Creation Success.");
        setupRestaurantMenu(userDetails, restid);
        log.info("Restauarnt Menu Added.");
        return Response.builder()
                .responseMsg(AppConstant.EMAIL_VERIFY)
                .respType(AppConstant.SUCCESS)
                .restId(restid)
                .emailId(username + AppConstant.USERADDED)
                .build();
    }
    public Customer getCustomerDetailfromId(Optional<String> userid) throws InvalidUserException, RepositoryOperationException {
        String userIdToString = userid.orElseThrow(() -> new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERIDERROR)));
        UserAccount response = (UserAccount) userRepoService.fetchExistingData(userIdToString);
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
    public void setupRestaurantMenu(Restaurant userDetails, String restid) {
        Menu menu = new Menu();
        menu.setEmailId(userDetails.getEmail());
        menu.setAddress(userDetails.getAddress());
        menu.setTimeStamp(getTodaysDate());
        menu.setRestaurantId(restid);
        menuRepoService.addNewEntry(menu);
    }
    public List<Address> addressDeserializerService() {
        return null;
    }

    public Date getTodaysDate() {
        return new java.util.Date();
    }
}
