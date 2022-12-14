package LF8.application.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String firstName;

    @Column
    @NonNull
    private String lastName;

    @Temporal(TemporalType.DATE)
    @NonNull
    private LocalDate dayOfBirth;

    @Column
    @NonNull
    private String gender;

    @Column(unique=true)
    @NonNull
    private String eMail;

    @Column
    @NonNull
    private String password;

    @Temporal(TemporalType.DATE)
    private LocalDate lastLogin;
}
