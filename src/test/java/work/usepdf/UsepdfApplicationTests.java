package work.usepdf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import work.usepdf.repository.ArrayNumberLearnedUnits;
import work.usepdf.service.EnService;
import work.usepdf.service.MurphyUnitsMap;
import work.usepdf.service.PdfProcessor;

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


    @Test
    public void murphyLessonMapTest() {
        Map<Integer, String> unitList = units.getUnits();
        unitList.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    public void getRandomUnits(){
        service.getRandomUnits(20).forEach(System.out::println);
    }

}
