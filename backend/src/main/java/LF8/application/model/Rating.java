package LF8.application.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

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
    private void validateFields() {
        assertThat(id).as(Fields.id).isNotNull();
        assertThat(comment).as(Fields.comment).isNotNull();
        assertThat(rating).as(Fields.rating).isNotNull();
        assertThat(userId).as(Fields.userId).isNotNull();
        assertThat(commentDate).as(Fields.commentDate).isNotNull();

    }
}


