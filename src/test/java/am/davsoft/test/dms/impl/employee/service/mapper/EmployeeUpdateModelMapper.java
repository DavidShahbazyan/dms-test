package am.davsoft.test.dms.impl.employee.service.mapper;

import am.davsoft.test.dms.api.employee.service.model.EmployeeUpdateModel;
import am.davsoft.test.dms.impl.employee.entity.Employee;
import am.davsoft.test.dms.impl.employee.service.builder.EmployeeBuilder;
import am.davsoft.test.dms.impl.employee.service.builder.EmployeeUpdateModelBuilder;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 31, 2020
 * Time: 23:16
 */
public class EmployeeUpdateModelMapper {
    public static Employee mapEmployeeUpdateModelToEmployee(final EmployeeUpdateModel model) {
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

    public static EmployeeUpdateModel mapEmployeeToEmployeeUpdateModel(final Employee employee) {
        return EmployeeUpdateModelBuilder.getInstance()
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
