package com.sangam.muscleplay.privacy_policy;

import com.sangam.muscleplay.support.SupportResponseModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivacyPolicyRepository extends MongoRepository<PrivacyPolicyResponseModel, String> {
}
