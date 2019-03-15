package work.usepdf.service;

import work.usepdf.model.database.Word;

import java.util.List;
import java.util.Optional;

public interface WordsService {
    List<Word> getAll();
    List<Word> getByUserId(Long userId);
    Word updateWord(Word word);
    Optional<Word> getWordById(Long wordId);
}
