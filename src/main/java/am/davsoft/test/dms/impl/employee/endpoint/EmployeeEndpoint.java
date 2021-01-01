package am.davsoft.test.dms.impl.employee.endpoint;

import am.davsoft.test.dms.api.employee.resource.EmployeeResource;
import am.davsoft.test.dms.api.employee.resource.model.EmployeeCreationDto;
import am.davsoft.test.dms.api.employee.resource.model.EmployeeDto;
import am.davsoft.test.dms.api.employee.resource.model.EmployeeUpdateDto;
import am.davsoft.test.dms.api.employee.service.EmployeeService;
import am.davsoft.test.dms.api.employee.service.model.EmployeeCreationModel;
import am.davsoft.test.dms.common.Gender;
import am.davsoft.test.dms.impl.employee.entity.Employee;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 11, 2020
 * Time: 03:21
 */
@RestController
public class EmployeeEndpoint implements EmployeeResource {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeEndpoint.class);

    private final EmployeeService employeeService;
    private final MapperFacade mapperFacade;

    @Autowired
    public EmployeeEndpoint(
            final EmployeeService employeeService,
            final MapperFacade mapperFacade
    ) {
        this.employeeService = employeeService;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        logger.trace("Requested to fetch all the employees");
        final List<Employee> employees = employeeService.getEmployees();
        final List<EmployeeDto> employeeDtos = mapperFacade.mapAsList(employees, EmployeeDto.class);
        logger.debug("Successfully retrieved employees {}", employeeDtos);
        return employeeDtos;
    }

    @Override
    public EmployeeDto getById(final Long employeeId) {
        logger.trace("");
        final Employee employee = employeeService.getById(employeeId);
        final EmployeeDto employeeDto = mapperFacade.map(employee, EmployeeDto.class);
        logger.debug("");
        return employeeDto;
    }

    @Override
    public EmployeeDto createEmployee(final EmployeeCreationDto employeeCreationDto) {
        logger.trace("");
        final EmployeeCreationModel creationModel = mapperFacade.map(employeeCreationDto, EmployeeCreationModel.class);
        final Employee employee = employeeService.createEmployee(creationModel);
        final EmployeeDto employeeDto = mapperFacade.map(employee, EmployeeDto.class);
        logger.debug("");
        return employeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(final Long employeeId, final EmployeeUpdateDto employeeUpdateDto) {
        logger.trace("");

        logger.debug("");
        return null;
    }

    @Override
    public void deleteEmployee(final Long employeeId) {
        logger.trace("");
        /* NOT IMPLEMENTED YET */
        logger.debug("");
    }
}
