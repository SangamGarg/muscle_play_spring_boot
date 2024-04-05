package com.sangam.muscleplay.support;

import com.sangam.muscleplay.about_us.AboutUsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends MongoRepository<SupportModel, String> {
}
