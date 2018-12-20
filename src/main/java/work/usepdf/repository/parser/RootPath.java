package work.usepdf.repository.parser;

import java.io.File;

public class RootPath {
    private static final String SRC = "src";
    private static final String MAIN = "main";
    private static final String RESOURCES = "resources";
    private static final String STATIC = "static";
    public static final File PATH = new File(
            SRC + File.separator
                    + MAIN + File.separator
                    + RESOURCES + File.separator
                    + STATIC);
    public static final String NEW_MURPHY_TXT = "new-murphy.txt";
}
