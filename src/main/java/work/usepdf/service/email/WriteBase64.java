package work.usepdf.service.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class WriteBase64 {

    private Logger logger = LoggerFactory.getLogger(WriteBase64.class);

    private String strBase64 = null;

    Optional<String> getBase64Pic(File file){
        try (FileInputStream imgFileIs = new FileInputStream(file)){
            byte imageData[] = new byte[(int) file.length()];
            imgFileIs.read(imageData);
            strBase64 = java.util.Base64.getEncoder().encodeToString(imageData);
        } catch (IOException e) {
            logger.error("Encode base64 exception.");
            e.printStackTrace();
        }
        return Optional.ofNullable(strBase64);
    }
}
