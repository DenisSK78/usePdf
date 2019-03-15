package work.usepdf.service;

import org.springframework.stereotype.Service;
import work.usepdf.model.database.Phrase;

import java.util.List;
import java.util.Optional;

@Service
public interface PhraseService {
    List<Phrase> getAll();
    List<Phrase> getByUserID(Long userId);
    Phrase updatePhrase(Phrase phrase);
    Optional<Phrase> getPhraseById(Long phraseId);
}
