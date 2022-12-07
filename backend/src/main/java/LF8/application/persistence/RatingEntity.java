package LF8.application.persistence;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RatingEntity {
    private Long id;
    private String comment;
    private int rating;
    private Long userId;
    private LocalDate commentDate;
}
