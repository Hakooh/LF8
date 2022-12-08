package LF8.application.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import static org.assertj.core.api.Assertions.*;
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
        validateFields();
    }
    private void validateFields() {
        assertThat(id).as(Fields.id).isNotNull();
        assertThat(eMail).as(Fields.eMail).isNotNull();
        assertThat(eMail).as(Fields.eMail).isNotEmpty();
        assertThat(password).as(Fields.eMail).isNotNull();
        assertThat(password).as(Fields.eMail).isNotEmpty();
        assertThat(lastLogin).as(Fields.lastLogin).isNotNull();
        assertThat(firstName).as(Fields.firstName).isNotNull();
        assertThat(firstName).as(Fields.firstName).isNotEmpty();
        assertThat(lastName).as(Fields.lastName).isNotNull();
        assertThat(lastName).as(Fields.lastName).isNotEmpty();
        assertThat(demographicInformation).as(Fields.demographicInformation).isNotNull();

    }
}
