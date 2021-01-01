package am.davsoft.test.dms.impl.employee.entity;

import am.davsoft.test.dms.common.Gender;
import am.davsoft.test.dms.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 14, 2020
 * Time: 01:05
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "passport_number", nullable = false, unique = true)
    private String passportNumber;

    @Column(name = "ssn", nullable = false, unique = true)
    private String ssn;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "registration_address", nullable = false)
    private String registrationAddress;

    @Column(name = "residential_address", nullable = false)
    private String residentialAddress;
}
