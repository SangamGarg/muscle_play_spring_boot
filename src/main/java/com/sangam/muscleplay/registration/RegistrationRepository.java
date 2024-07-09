package com.sangam.muscleplay.registration;

import com.sangam.muscleplay.registration.model.UserDetailsResponseModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends MongoRepository<UserDetailsResponseModel, String> {

}
