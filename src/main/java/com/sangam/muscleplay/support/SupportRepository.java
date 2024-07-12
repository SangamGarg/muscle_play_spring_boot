package com.sangam.muscleplay.support;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends MongoRepository<SupportResponseModel, String> {
}
