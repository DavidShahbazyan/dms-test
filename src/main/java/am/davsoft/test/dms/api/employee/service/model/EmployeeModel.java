package am.davsoft.test.dms.api.employee.service.model;

import am.davsoft.test.dms.common.Gender;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 17, 2020
 * Time: 23:16
 */
@Data
public class EmployeeModel {
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDateTime birthDate;
    private Gender gender;
    private String passportNumber;
    private String ssn;
    private String phoneNumber;
    private String email;
    private String registrationAddress;
    private String residentialAddress;
}
