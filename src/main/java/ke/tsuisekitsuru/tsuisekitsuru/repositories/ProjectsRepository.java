package ke.tsuisekitsuru.tsuisekitsuru.repositories;

import ke.tsuisekitsuru.tsuisekitsuru.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Projects, Long> {
}
