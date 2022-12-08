package LF8.application.converters;

import LF8.application.models.User;
import LF8.application.persistence.UserEntity;

// TODO: Set<Rating> userRatings & DemographicInformation nachschauen (User.java)
public class UserEntityToUserConverter {
    public User convert(UserEntity userEntity) {
        return User.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .eMail(userEntity.getEMail())
                .password(userEntity.getPassword())
                .lastLogin(userEntity.getLastLogin()).build();
    }
}
