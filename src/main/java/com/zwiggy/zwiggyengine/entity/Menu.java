package com.zwiggy.zwiggyengine.entity;

import com.zwiggy.zwiggyengine.model.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "zwiggyengine")
public class Menu {
    @Id
    private String restaurantId;
    private String emailId;
    private List<Address> address;
    private Date timeStamp;

}
