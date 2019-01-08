package work.usepdf.service.email;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import work.usepdf.model.MailRequest;
import work.usepdf.model.MailResponse;
import work.usepdf.model.Unit;
import work.usepdf.repository.parser.RootPath;
import work.usepdf.service.EmailService;
import work.usepdf.service.EnService;
import work.usepdf.service.PdfProcessor;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    private static String PIC_PATH = RootPath.PATH + "/pics/";

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration config;

    @Autowired
    private EnService enService;

    @Autowired
    private PdfProcessor pdfProcessor;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private WriteBase64 writeBase64;

    public MailResponse sendEmail(MailRequest request){
        MailResponse response = new MailResponse();
        MimeMessage massage = sender.createMimeMessage();

        try {

            MimeMessageHelper helper = new MimeMessageHelper(massage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Template t = config.getTemplate("mail-example.ftl");
            Map<String, Object> templateModel = new HashMap<>();
            List<Unit> unitList = enService.getRandomUnits(3);
            templateModel.put("units", unitList);

            String base64Image = writeBase64.getBase64Pic(
                    new File(PIC_PATH + "megaphone.png")).orElse("");
            templateModel.put("imgAsBase64", base64Image);

            DataSource source = new ByteArrayDataSource(
                    pdfProcessor.getPdfForEmail(unitList).toByteArray(), "application/pdf");
            helper.addAttachment("example.pdf", source);

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, templateModel);

            helper.setTo(request.getTo());
            helper.setText(html, true);
            helper.setSubject(request.getSubject());
            helper.setFrom(request.getFrom());

            sender.send(massage);

            response.setMassage("mail send to: " + request.getTo());
            response.setStatus(Boolean.TRUE);

        } catch (MessagingException e) {
            logger.error("EmailService create mail response exception.", e);
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("EmailService read template io exception.", e);
            e.printStackTrace();
        } catch (TemplateException e) {
            logger.error("EmailService create html by template exception.", e);
            e.printStackTrace();
        }

        return response;
    }
}
