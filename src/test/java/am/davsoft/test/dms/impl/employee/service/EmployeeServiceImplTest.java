package am.davsoft.test.dms.impl.employee.service;

import am.davsoft.test.dms.api.employee.service.model.EmployeeCreationModel;
import am.davsoft.test.dms.api.employee.service.model.EmployeeUpdateModel;
import am.davsoft.test.dms.impl.employee.entity.Employee;
import am.davsoft.test.dms.impl.employee.repository.EmployeeRepository;
import am.davsoft.test.dms.impl.employee.service.builder.EmployeeBuilder;
import am.davsoft.test.dms.impl.employee.service.builder.EmployeeCreationModelBuilder;
import am.davsoft.test.dms.impl.employee.service.builder.EmployeeUpdateModelBuilder;
import am.davsoft.test.dms.impl.employee.service.mapper.EmployeeCreationModelMapper;
import am.davsoft.test.dms.impl.employee.service.mapper.EmployeeUpdateModelMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 20, 2020
 * Time: 11:38
 */
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach

    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //region getEmployees
    @Test
    void getEmployees() {
        //arrange
        when(employeeRepository.findAll()).thenReturn(Collections.emptyList());
        //act
        final List<Employee> employeeList = employeeService.getEmployees();
        //assert
        assertThat(employeeList).isEmpty();
    }
    //endregion

    //region getById
    @Test
    void getById_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> employeeService.getById(null));
    }

    @Test
    void getById_Success() {
        //arrange
        final Employee expectedEmployee = EmployeeBuilder.getInstance().setId(1L).build();
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(expectedEmployee));
        //act
        final Employee result = employeeService.getById(1L);
        //assert
        assertThat(result).isNotNull().isEqualTo(expectedEmployee);
    }
    //endregion

    //region createEmployee
    @Test
    void createEmployee_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> employeeService.createEmployee(null));
    }

    @Test
    void createEmployee_Success() {
        //arrange
        final EmployeeCreationModel employeeCreationModel = EmployeeCreationModelBuilder.getInstance().build();
        final Employee expectedEmployeeToSave = EmployeeCreationModelMapper.mapEmployeeCreationModelToEmployee(employeeCreationModel);
        final Employee expectedCreatedEmployee = EmployeeCreationModelMapper.mapEmployeeCreationModelToEmployee(employeeCreationModel);
        final ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        when(employeeRepository.save(any(Employee.class))).thenReturn(expectedCreatedEmployee);
        //act
        final Employee createdEmployee = employeeService.createEmployee(employeeCreationModel);
        //assert
        verify(employeeRepository, times(1)).save(employeeArgumentCaptor.capture());
        assertThat(employeeArgumentCaptor.getValue()).isNotNull().isEqualTo(expectedEmployeeToSave);
        assertThat(createdEmployee)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expectedCreatedEmployee);
    }
    //endregion

    //region updateEmployee
    @ParameterizedTest
    @MethodSource("updateEmployeeInvalidArguments")
    void updateEmployee_IllegalArgumentException(final Long employeeId, final EmployeeUpdateModel employeeUpdateModel) {
        assertThrows(IllegalArgumentException.class, () -> employeeService.updateEmployee(employeeId, employeeUpdateModel));
    }

    @Test
    void updateEmployee_Success() {
        //arrange
        final Employee baseEmployee = EmployeeBuilder.getInstance().build();
        final EmployeeUpdateModel employeeUpdateModel = EmployeeUpdateModelMapper.mapEmployeeToEmployeeUpdateModel(baseEmployee);
        employeeUpdateModel.setPhoneNumber(baseEmployee.getPhoneNumber() + "-123");
        final Employee expectedEmployee = EmployeeUpdateModelMapper.mapEmployeeUpdateModelToEmployee(employeeUpdateModel);

        final ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        when(employeeRepository.findById(baseEmployee.getId())).thenReturn(Optional.of(baseEmployee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(expectedEmployee);
        //act
        final Employee createdEmployee = employeeService.updateEmployee(baseEmployee.getId(), employeeUpdateModel);
        expectedEmployee.setUpdated(createdEmployee.getUpdated());
        //assert
        verify(employeeRepository, times(1)).save(employeeArgumentCaptor.capture());
        assertThat(employeeArgumentCaptor.getValue()).isNotNull().isEqualTo(expectedEmployee);
        assertThat(createdEmployee)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("updated")
                .isEqualTo(expectedEmployee);
    }
    //endregion

    //region deleteEmployee
    @Test
    void deleteEmployee_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> employeeService.deleteEmployee(null));
    }

    @Test
    void deleteEmployee_Success() {
        //arrange
        final LocalDateTime creationDate = LocalDateTime.now().minusDays(1);
        final Employee employee = EmployeeBuilder.getInstance()
                .setCreated(creationDate)
                .setUpdated(creationDate)
                .build();
        final ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        when(employeeRepository.save(employeeArgumentCaptor.capture())).thenReturn(null);
        //act
        employeeService.deleteEmployee(employee.getId());
        //assert
        assertThat(employeeArgumentCaptor.getValue())
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("removed", "updated")
                .isEqualTo(employee);
        assertThat(employeeArgumentCaptor.getValue().getRemoved())
                .isNotNull()
                .isEqualTo(employeeArgumentCaptor.getValue().getUpdated())
                .isAfter(creationDate);
    }
    //endregion


    //region HELPERS

    private static Stream<Arguments> updateEmployeeInvalidArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(1L, null),
                Arguments.of(null, EmployeeUpdateModelBuilder.getInstance().build())
        );
    }

    //endregion
}