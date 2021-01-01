package am.davsoft.test.dms.api.employee.resource.model;

import am.davsoft.test.dms.common.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 11, 2020
 * Time: 02:59
 */
@Data
public class EmployeeDto {
    @NonNull
    @JsonProperty("id")
    private Long id;

    @NonNull
    @JsonProperty("firstName")
    private String firstName;

    @NonNull
    @JsonProperty("secondName")
    private String secondName;

    @NonNull
    @JsonProperty("lastName")
    private String lastName;

    @NonNull
    @JsonProperty("birthDate")
    private LocalDateTime birthDate;

    @NonNull
    @JsonProperty("gender")
    private Gender gender;

    @NonNull
    @JsonProperty("passportNumber")
    private String passportNumber;

    @NonNull
    @JsonProperty("ssn")
    private String ssn;

    @NonNull
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @NonNull
    @JsonProperty("email")
    private String email;

    @NonNull
    @JsonProperty("registrationAddress")
    private String registrationAddress;

    @NonNull
    @JsonProperty("residentialAddress")
    private String residentialAddress;
}
