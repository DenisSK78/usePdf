package work.usepdf.repository.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static work.usepdf.repository.parser.RootPath.NEW_MURPHY_TXT;


public class MurphyUnitsText {

    private Logger logger = LoggerFactory.getLogger(MurphyUnitsText.class);

    public Map<Integer, String> getMurphyLesson() {

        File file = new File(RootPath.PATH, NEW_MURPHY_TXT);

        if (file.exists()) {

            List<String> units = new ArrayList<>();

            try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))){

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    units.add(line);
                }

            } catch (FileNotFoundException e) {
                logger.info("File " + NEW_MURPHY_TXT + " doesn't exist!");
                e.printStackTrace();
            }

            return units.stream()
                    .map(e -> e.split(":"))
                    .collect(Collectors.toMap(e -> new Integer(e[0]), e -> e[1].trim()));
        }
        return Collections.emptyMap();
    }
}
