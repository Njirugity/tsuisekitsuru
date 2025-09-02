package ke.tsuisekitsuru.tsuisekitsuru.repositories;

import ke.tsuisekitsuru.tsuisekitsuru.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
