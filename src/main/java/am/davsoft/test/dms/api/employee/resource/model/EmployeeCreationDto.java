package am.davsoft.test.dms.api.employee.resource.model;

import am.davsoft.test.dms.common.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 11, 2020
 * Time: 03:03
 */
@Data
public class EmployeeCreationDto implements Serializable {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("secondName")
    private String secondName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("birthDate")
    private LocalDateTime birthDate;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("passportNumber")
    private String passportNumber;

    @JsonProperty("ssn")
    private String ssn;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("registrationAddress")
    private String registrationAddress;

    @JsonProperty("residentialAddress")
    private String residentialAddress;
}
