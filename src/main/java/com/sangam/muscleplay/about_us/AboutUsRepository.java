package com.sangam.muscleplay.about_us;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsRepository extends MongoRepository<AboutUsResponseModel, String> {

}
