package work.usepdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.usepdf.model.database.Phrase;
import work.usepdf.model.database.User;

import java.util.List;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    List<Phrase> findByUser(User user);
}
