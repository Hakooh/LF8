package LF8.application.persistence;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "RATINGS")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comment;

    @Column
    private int rating;

    @OneToOne
    private UserEntity user;

    @Temporal(TemporalType.DATE)
    @JsonDeserialize(as = LocalDate.class)
    private LocalDate commentDate;
}
