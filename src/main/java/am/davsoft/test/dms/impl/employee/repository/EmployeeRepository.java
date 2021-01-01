package am.davsoft.test.dms.impl.employee.repository;

import am.davsoft.test.dms.impl.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 13, 2020
 * Time: 15:40
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    @Query(value = "SELECT em from Employee em where em.removed IS NULL")
    List<Employee> findAll();
}
