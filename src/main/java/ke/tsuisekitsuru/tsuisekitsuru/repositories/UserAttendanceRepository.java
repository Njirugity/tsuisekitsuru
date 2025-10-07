package ke.tsuisekitsuru.tsuisekitsuru.repositories;

import ke.tsuisekitsuru.tsuisekitsuru.models.UserAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAttendanceRepository extends JpaRepository<UserAttendance, Long> {
}
