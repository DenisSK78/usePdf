package work.usepdf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import work.usepdf.model.User;
import work.usepdf.repository.ArrayNumberLearnedUnits;
import work.usepdf.repository.UserRepository;
import work.usepdf.service.EnService;
import work.usepdf.service.MurphyUnitsMap;
import work.usepdf.service.PdfProcessor;
import work.usepdf.service.security.JwtUser;
import work.usepdf.service.security.JwtUserFactory;

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
}
