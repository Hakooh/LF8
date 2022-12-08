package LF8.application.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@Data
@FieldNameConstants
public class DemographicInformation {
    private String gender;
    private LocalDate dayOfBirth;
    private String address;
    private String city;

    @Builder
    public DemographicInformation(
            String gender,
            LocalDate dayOfBirth,
            String address,
            String city) {
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.city = city;
        validateFields();
    }

    private void validateFields() {
        assertThat(gender).as(Fields.gender).isNotNull();
        assertThat(dayOfBirth).as(Fields.dayOfBirth).isNotNull();
        assertThat(address).as(Fields.address).isNotEmpty();
        assertThat(city).as(Fields.city).isNotEmpty();
        assertThat(city).as(Fields.city).isNotNull();
    }
}
