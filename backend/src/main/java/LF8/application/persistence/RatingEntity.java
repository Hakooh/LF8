package LF8.application.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class RatingEntity {

    @Id
    private Long id;

    @Column
    private String comment;

    @Column
    private int rating;

    @Column
    private Long userId;

    @Column
    private LocalDate commentDate;
}
