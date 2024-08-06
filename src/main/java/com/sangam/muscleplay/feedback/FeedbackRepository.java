package com.sangam.muscleplay.feedback;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends MongoRepository<FeedbackResponseModel, String> {
    Optional<FeedbackResponseModel> findByEmail(String email);
}
