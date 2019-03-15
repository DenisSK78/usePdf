package work.usepdf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.usepdf.model.database.User;
import work.usepdf.model.database.Word;
import work.usepdf.repository.UserRepository;
import work.usepdf.repository.WordRepository;
import work.usepdf.service.WordsService;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordsService {

    private final WordRepository wordRepository;
    private final UserRepository userRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository, UserRepository userRepository) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Word> getAll() {
        return wordRepository.findAll();
    }

    @Override
    public List<Word> getByUserId(Long userId) {
        User user = userRepository.getOne(userId);
        return wordRepository.findByUser(user);
    }

    @Override
    public Word updateWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Optional<Word> getWordById(Long wordId) {
        return wordRepository.findById(wordId);
    }
}
