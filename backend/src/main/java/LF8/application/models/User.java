package LF8.application.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import java.time.LocalDate;
import java.util.Set;

@Data
@FieldNameConstants
public class User {

    private Long id;
    private String eMail;
    private String password;
    private LocalDate lastLogin;
    private String firstName;
    private String lastName;
    private Set<Rating> userRatings;
    private DemographicInformation demographicInformation;

    @Builder
    public User(
            Long id,
            String eMail,
            String password,
            LocalDate lastLogin,
            String firstName,
            String lastName,
            Set<Rating> userRatings,
            DemographicInformation demographicInformation) {
        this.id = id;
        this.eMail = eMail;
        this.password = password;
        this.lastLogin = lastLogin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRatings = userRatings;
        this.demographicInformation = demographicInformation;
    }
}
