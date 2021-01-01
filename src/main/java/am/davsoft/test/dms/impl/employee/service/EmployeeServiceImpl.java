package am.davsoft.test.dms.impl.employee.service;

import am.davsoft.test.dms.api.employee.service.EmployeeService;
import am.davsoft.test.dms.api.employee.service.model.EmployeeCreationModel;
import am.davsoft.test.dms.api.employee.service.model.EmployeeUpdateModel;
import am.davsoft.test.dms.impl.employee.entity.Employee;
import am.davsoft.test.dms.impl.employee.repository.EmployeeRepository;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 17, 2020
 * Time: 23:12
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        logger.trace("Requested to fetch the employees");
        final List<Employee> employeeList = employeeRepository.findAll();
        logger.debug("Successfully retrieved employees - {}", employeeList);
        return employeeList;
    }

    @Override
    public Employee getById(final Long employeeId) {
        logger.trace("Requested to fetch an employee with id - {}", employeeId);
        Assert.notNull(employeeId, "The employeeId can not be null");

        final Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> {
            logger.error("No employee was found for id - {}", employeeId);
            throw new EntityNotFoundException(String.format("No employee was found for id - %s", employeeId));
        });
        logger.debug("Successfully retrieved the employee with id - {}", employeeId);
        return employee;
    }

    @Override
    public Employee createEmployee(final EmployeeCreationModel employeeCreationModel) {
        logger.trace("Requested to create an employee");
        Assert.notNull(employeeCreationModel, "The employeeCreationModel can not be null");

        final Employee employee = new Employee();
        employee.setFirstName(employeeCreationModel.getFirstName());
        employee.setSecondName(employeeCreationModel.getSecondName());
        employee.setLastName(employeeCreationModel.getLastName());
        employee.setBirthDate(employeeCreationModel.getBirthDate());
        employee.setGender(employeeCreationModel.getGender());
        employee.setPassportNumber(employeeCreationModel.getPassportNumber());
        employee.setSsn(employeeCreationModel.getSsn());
        employee.setPhoneNumber(employeeCreationModel.getPhoneNumber());
        employee.setEmail(employeeCreationModel.getEmail());
        employee.setRegistrationAddress(employeeCreationModel.getRegistrationAddress());
        employee.setResidentialAddress(employeeCreationModel.getResidentialAddress());
        employee.setCreated(LocalDateTime.now());
        employee.setUpdated(employee.getCreated());

        final Employee createdEmployee = employeeRepository.save(employee);
        logger.debug("Successfully created an employee {}", createdEmployee);
        return createdEmployee;
    }

    @Override
    public Employee updateEmployee(final Long employeeId, final EmployeeUpdateModel employeeUpdateModel) {
        logger.trace("Requested to update the employee with id - {} and employeeUpdateModel - {}", employeeId, employeeUpdateModel);
        Assert.notNull(employeeId, "The employeeId can not be null");
        Assert.notNull(employeeUpdateModel, "The employeeUpdateModel can not be null");

        final Employee employee = getById(employeeId);
        employee.setFirstName(employeeUpdateModel.getFirstName());
        employee.setSecondName(employeeUpdateModel.getSecondName());
        employee.setLastName(employeeUpdateModel.getLastName());
        employee.setBirthDate(employeeUpdateModel.getBirthDate());
        employee.setGender(employeeUpdateModel.getGender());
        employee.setPassportNumber(employeeUpdateModel.getPassportNumber());
        employee.setSsn(employeeUpdateModel.getSsn());
        employee.setPhoneNumber(employeeUpdateModel.getPhoneNumber());
        employee.setEmail(employeeUpdateModel.getEmail());
        employee.setRegistrationAddress(employeeUpdateModel.getRegistrationAddress());
        employee.setResidentialAddress(employeeUpdateModel.getResidentialAddress());
        employee.setUpdated(LocalDateTime.now());

        final Employee updatedEmployee = employeeRepository.save(employee);
        logger.debug("Successfully updated the employee {}", updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(final Long employeeId) {
        logger.trace("Requested to remove the employee by id - {}", employeeId);
        Assert.notNull(employeeId, "The employeeId can not be null");

        final Employee employee = getById(employeeId);
        employee.setRemoved(LocalDateTime.now());
        employee.setUpdated(employee.getRemoved());

        employeeRepository.save(employee);
        logger.debug("Successfully removed the employee by id - {}", employeeId);
    }
}
