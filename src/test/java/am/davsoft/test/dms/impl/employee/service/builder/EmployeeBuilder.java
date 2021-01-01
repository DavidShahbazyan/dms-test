package am.davsoft.test.dms.impl.employee.service.builder;

import am.davsoft.test.dms.common.Gender;
import am.davsoft.test.dms.impl.employee.entity.Employee;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 20, 2020
 * Time: 16:29
 */
public final class EmployeeBuilder {
    private Long id = (long) (Math.random() * 1000);
    private String firstName = UUID.randomUUID().toString();
    private String secondName = UUID.randomUUID().toString();
    private String lastName = UUID.randomUUID().toString();
    private LocalDateTime birthDate = LocalDateTime.now();
    private Gender gender = Gender.MALE;
    private String passportNumber = UUID.randomUUID().toString();
    private String ssn = UUID.randomUUID().toString();
    private String phoneNumber = UUID.randomUUID().toString();
    private String email = UUID.randomUUID().toString();
    private String registrationAddress = UUID.randomUUID().toString();
    private String residentialAddress = UUID.randomUUID().toString();
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated = this.created;
    private LocalDateTime removed = null;

    public static EmployeeBuilder getInstance() {
        return new EmployeeBuilder();
    }

    public Employee build() {
        final Employee model = new Employee();
        model.setId(this.id);
        model.setFirstName(this.firstName);
        model.setSecondName(this.secondName);
        model.setLastName(this.lastName);
        model.setBirthDate(this.birthDate);
        model.setGender(this.gender);
        model.setPassportNumber(this.passportNumber);
        model.setSsn(this.ssn);
        model.setPhoneNumber(this.phoneNumber);
        model.setEmail(this.email);
        model.setRegistrationAddress(this.registrationAddress);
        model.setResidentialAddress(this.residentialAddress);
        model.setCreated(this.created);
        model.setUpdated(this.updated);
        model.setRemoved(this.removed);
        return model;
    }

    public EmployeeBuilder setId(final Long id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder setSecondName(final String secondName) {
        this.secondName = secondName;
        return this;
    }

    public EmployeeBuilder setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder setBirthDate(final LocalDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public EmployeeBuilder setGender(final Gender gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeBuilder setPassportNumber(final String passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }

    public EmployeeBuilder setSsn(final String ssn) {
        this.ssn = ssn;
        return this;
    }

    public EmployeeBuilder setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmployeeBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public EmployeeBuilder setRegistrationAddress(final String registrationAddress) {
        this.registrationAddress = registrationAddress;
        return this;
    }

    public EmployeeBuilder setResidentialAddress(final String residentialAddress) {
        this.residentialAddress = residentialAddress;
        return this;
    }

    public EmployeeBuilder setCreated(final LocalDateTime created) {
        this.created = created;
        return this;
    }

    public EmployeeBuilder setUpdated(final LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

    public EmployeeBuilder setRemoved(final LocalDateTime removed) {
        this.removed = removed;
        return this;
    }
}
