package work.usepdf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;
import work.usepdf.model.database.Phrase;
import work.usepdf.model.database.User;
import work.usepdf.model.database.Word;
import work.usepdf.repository.ArrayNumberLearnedUnits;
import work.usepdf.repository.PhraseRepository;
import work.usepdf.repository.UserRepository;
import work.usepdf.service.EnService;
import work.usepdf.service.MurphyUnitsMap;
import work.usepdf.service.PdfProcessor;
import work.usepdf.service.PhraseService;
import work.usepdf.service.WordsService;
import work.usepdf.service.security.JwtUser;
import work.usepdf.service.security.JwtUserFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsepdfApplicationTests {

    private Logger logger = LoggerFactory.getLogger(UsepdfApplicationTests.class);

    @Autowired
    private MurphyUnitsMap units;

    @Autowired
    private EnService service;

    @Autowired
    private ArrayNumberLearnedUnits numberLearnedUnits;

    @Autowired
    private PdfProcessor pdfProcessor;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WordsService wordsService;

    @Autowired
    private PhraseService phraseService;


    @Test
    public void murphyLessonMapTest() {
        Map<Integer, String> unitList = units.getUnits();
        unitList.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    public void getRandomUnits(){
        service.getRandomUnits(20).forEach(System.out::println);
    }

    @Test
    public void getUserByUserRepository(){
        User user = userRepository.findByEmail("user1@user1.ru");
        System.out.println(user);
    }

    @Test
    public void getJwtUser(){
        JwtUser jwtUser = JwtUserFactory.create(userRepository.findByEmail("user@user.ru"));
        System.out.println(jwtUser);
    }

    @Test
    public void decodePassword(){
        System.out.println(BCrypt.hashpw("user2", BCrypt.gensalt()));
    }

    @Test
    public void getWorldRep(){
        List<Word> words = wordsService.getAll();
        List<Word> words1 = wordsService.getByUserId(1L);
        printList(words);
        printList(words1);
    }

    @Test
    public void getPhraseRep(){
        List<Phrase> phrases = phraseService.getAll();
        List<Phrase> phrases1 = phraseService.getByUserID(1L);
        printList(phrases);
        printList(phrases1);
    }

    private <E> void printList (List<E> list){
        list.forEach(System.out::println);
    }

    @Test
    public void writeLogForUpdate(){
        List<Phrase> phrases = phraseService.getByUserID(1L);
        Phrase phrase = phrases.get(0);

        System.out.println(phrase.getTextEn());

        phrase.setTextEn(phrase.getTextEn() + " " + LocalDate.now());
        Long phraseId = phrase.getId();
        phraseService.updatePhrase(phrase);
        phrase = phraseService.getPhraseById(1L).orElse(new Phrase());

        System.out.println(phrase.getTextEn());

        String strTextEn = phrase.getTextEn();
        String [] arrStr = strTextEn.trim().split(" ");

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < arrStr.length - 1; i++) {
            buf.append(" ").append(arrStr[i]);
        }
        phrase.setTextEn(buf.toString().trim());
        phraseService.updatePhrase(phrase);
        phrase = phraseService.getPhraseById(1L).orElse(new Phrase());

        System.out.println(phrase.getTextEn());
    }
}
