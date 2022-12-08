package LF8.application.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Temporal(TemporalType.DATE)
    private LocalDate dayOfBirth;

    @Column
    private String gender;

    @Column
    private String eMail;

    @Column
    private String password;

    @Temporal(TemporalType.DATE)
    private LocalDate lastLogin;
}
