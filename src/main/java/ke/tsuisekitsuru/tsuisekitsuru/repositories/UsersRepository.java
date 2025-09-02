package ke.tsuisekitsuru.tsuisekitsuru.repositories;

import ke.tsuisekitsuru.tsuisekitsuru.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
