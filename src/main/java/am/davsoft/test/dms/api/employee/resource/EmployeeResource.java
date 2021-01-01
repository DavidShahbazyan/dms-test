package am.davsoft.test.dms.api.employee.resource;

import am.davsoft.test.dms.api.employee.resource.model.EmployeeCreationDto;
import am.davsoft.test.dms.api.employee.resource.model.EmployeeDto;
import am.davsoft.test.dms.api.employee.resource.model.EmployeeUpdateDto;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 11, 2020
 * Time: 01:21
 */
@RequestMapping("/employees")
public interface EmployeeResource {
    @GetMapping
    List<EmployeeDto> getAllEmployees();

    @GetMapping("/{id}")
    EmployeeDto getById(@NonNull @PathVariable("id") final Long employeeId);

    @PostMapping
    EmployeeDto createEmployee(@NonNull final EmployeeCreationDto employeeCreationDto);

    @PatchMapping("/{id}")
    EmployeeDto updateEmployee(@NonNull @PathVariable("id") final Long employeeId, final EmployeeUpdateDto employeeUpdateDto);

    @DeleteMapping("/{id}")
    void deleteEmployee(@NonNull @PathVariable("id") final Long employeeId);
}
