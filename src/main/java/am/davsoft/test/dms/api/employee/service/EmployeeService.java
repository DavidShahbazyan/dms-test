package am.davsoft.test.dms.api.employee.service;

import am.davsoft.test.dms.api.employee.service.model.EmployeeCreationModel;
import am.davsoft.test.dms.api.employee.service.model.EmployeeUpdateModel;
import am.davsoft.test.dms.impl.employee.entity.Employee;

import java.util.List;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 17, 2020
 * Time: 23:12
 */
public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getById(final Long employeeId);

    Employee createEmployee(final EmployeeCreationModel employeeCreationModel);

    Employee updateEmployee(final Long employeeId, final EmployeeUpdateModel employeeUpdateModel);

    void deleteEmployee(final Long employeeId);
}
