package LF8.application.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;


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
    }
}
