package ke.tsuisekitsuru.tsuisekitsuru.repositories;

import ke.tsuisekitsuru.tsuisekitsuru.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
