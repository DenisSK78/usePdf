package work.usepdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.usepdf.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByEmail(String username);
}
