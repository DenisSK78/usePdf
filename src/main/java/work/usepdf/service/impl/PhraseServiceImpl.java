package work.usepdf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.usepdf.model.database.Phrase;
import work.usepdf.model.database.User;
import work.usepdf.repository.PhraseRepository;
import work.usepdf.repository.UserRepository;
import work.usepdf.service.PhraseService;
import work.usepdf.service.anotation.LogUpdate;

import java.util.List;
import java.util.Optional;

@Service
public class PhraseServiceImpl implements PhraseService {

    private final PhraseRepository phraseRepository;
    private final UserRepository userRepository;

    @Autowired
    public PhraseServiceImpl(PhraseRepository phraseRepository, UserRepository userRepository) {
        this.phraseRepository = phraseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Phrase> getAll() {
        return phraseRepository.findAll();
    }

    @Override
    public List<Phrase> getByUserID(Long userId) {
        User user = userRepository.getOne(userId);
        return phraseRepository.findByUser(user);
    }

    @LogUpdate
    @Override
    public Phrase updatePhrase(Phrase phrase) {
        return phraseRepository.save(phrase);
    }

    @Override
    public Optional<Phrase> getPhraseById(Long phraseId) {
        return phraseRepository.findById(phraseId);
    }
}
