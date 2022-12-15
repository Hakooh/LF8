package LF8.application.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "USERS")
public class UserEntity {

    private static final String GENERATOR = "userEntity_id.generator";

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = "userEntity_seq", allocationSize = 1)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name="day_of_birth")
    private LocalDate dayOfBirth;

    @Column(name="gender")
    private String gender;

    @Column(name="e_mail")
    private String eMail;

    @Column(name="password")
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name="last_login")
    private LocalDate lastLogin;

    @OneToMany(mappedBy = "user")
    private Set<RatingEntity> ratings;
}
