package work.usepdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.usepdf.model.database.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        User findByEmail(String username);
}
