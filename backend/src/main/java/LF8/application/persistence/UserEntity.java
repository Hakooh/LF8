package LF8.application.persistence;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dayOfBirth;
    private String gender;
    private String eMail;
    private String password;
    private LocalDate lastLogin;
}
