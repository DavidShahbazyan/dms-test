package am.davsoft.test.dms.impl.employee.service.mapper;

import am.davsoft.test.dms.api.employee.service.model.EmployeeCreationModel;
import am.davsoft.test.dms.impl.employee.entity.Employee;
import am.davsoft.test.dms.impl.employee.service.builder.EmployeeBuilder;
import am.davsoft.test.dms.impl.employee.service.builder.EmployeeCreationModelBuilder;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 20, 2020
 * Time: 16:26
 */
public final class EmployeeCreationModelMapper {
    public static Employee mapEmployeeCreationModelToEmployee(final EmployeeCreationModel model) {
        return EmployeeBuilder.getInstance()
                .setFirstName(model.getFirstName())
                .setSecondName(model.getSecondName())
                .setLastName(model.getLastName())
                .setBirthDate(model.getBirthDate())
                .setGender(model.getGender())
                .setPassportNumber(model.getPassportNumber())
                .setSsn(model.getSsn())
                .setPhoneNumber(model.getPhoneNumber())
                .setEmail(model.getEmail())
                .setRegistrationAddress(model.getRegistrationAddress())
                .setResidentialAddress(model.getResidentialAddress())
                .build();
    }

    public static EmployeeCreationModel mapEmployeeToEmployeeCreationModel(final Employee employee) {
        return EmployeeCreationModelBuilder.getInstance()
                .setFirstName(employee.getFirstName())
                .setSecondName(employee.getSecondName())
                .setLastName(employee.getLastName())
                .setBirthDate(employee.getBirthDate())
                .setGender(employee.getGender())
                .setPassportNumber(employee.getPassportNumber())
                .setSsn(employee.getSsn())
                .setPhoneNumber(employee.getPhoneNumber())
                .setEmail(employee.getEmail())
                .setRegistrationAddress(employee.getRegistrationAddress())
                .setResidentialAddress(employee.getResidentialAddress())
                .build();
    }
}
