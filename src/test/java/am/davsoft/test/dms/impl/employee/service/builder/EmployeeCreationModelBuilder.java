package am.davsoft.test.dms.impl.employee.service.builder;

import am.davsoft.test.dms.api.employee.service.model.EmployeeCreationModel;
import am.davsoft.test.dms.common.Gender;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 20, 2020
 * Time: 16:29
 */
public final class EmployeeCreationModelBuilder {
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

    public static EmployeeCreationModelBuilder getInstance() {
        return new EmployeeCreationModelBuilder();
    }

    public EmployeeCreationModel build() {
        final EmployeeCreationModel model = new EmployeeCreationModel();
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
        return model;
    }

    public EmployeeCreationModelBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeCreationModelBuilder setSecondName(final String secondName) {
        this.secondName = secondName;
        return this;
    }

    public EmployeeCreationModelBuilder setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeCreationModelBuilder setBirthDate(final LocalDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public EmployeeCreationModelBuilder setGender(final Gender gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeCreationModelBuilder setPassportNumber(final String passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }

    public EmployeeCreationModelBuilder setSsn(final String ssn) {
        this.ssn = ssn;
        return this;
    }

    public EmployeeCreationModelBuilder setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmployeeCreationModelBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public EmployeeCreationModelBuilder setRegistrationAddress(final String registrationAddress) {
        this.registrationAddress = registrationAddress;
        return this;
    }

    public EmployeeCreationModelBuilder setResidentialAddress(final String residentialAddress) {
        this.residentialAddress = residentialAddress;
        return this;
    }
}
