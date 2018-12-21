package work.usepdf;

import work.usepdf.repository.parser.RootPath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {

        String base64Image = "";
        File file = new File(RootPath.PATH + "/pics/megaphone.png");
        try (FileInputStream imgFileIs = new FileInputStream(file)){
            byte imageData[] = new byte[(int) file.length()];
            imgFileIs.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(base64Image);

    }
}
