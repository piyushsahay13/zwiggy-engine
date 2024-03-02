package com.zwiggy.zwiggyengine.repositories;

import com.zwiggy.zwiggyengine.entity.BranchEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface MenuRepository extends MongoRepository<BranchEntity,String> {

    BranchEntity findByEmailId(String email);
}
