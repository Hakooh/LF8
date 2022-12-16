package LF8.application.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;


@Data
@FieldNameConstants
public class Rating {
    private Long id;
    private String comment;
    private int rating;
    private Long userId;
    private LocalDate commentDate;

    @Builder
    public Rating(Long id, String comment, int rating, Long userId, LocalDate commentDate) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.userId = userId;
        this.commentDate = commentDate;
    }

}


