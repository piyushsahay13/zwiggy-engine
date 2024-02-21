package com.zwiggy.zwiggyengine.repositories;

import com.zwiggy.zwiggyengine.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface MenuRepository extends MongoRepository<Menu,String> {
}
