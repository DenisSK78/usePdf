package work.usepdf.service.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;
import work.usepdf.model.Unit;
import work.usepdf.repository.parser.RootPath;
import work.usepdf.service.PdfProcessor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class PdfProcessorImpl implements PdfProcessor {

    private static final String PDF = "pdf-example.ftl";
    private static final String ENCODING = "UTF-8";
    private final Configuration config;

    @Autowired
    public PdfProcessorImpl(Configuration config) {
        this.config = config;
    }

    @Override
    public ByteArrayOutputStream getPdfForEmail(List<Unit> unitList) {

        ITextRenderer renderer = new ITextRenderer();
        Path path = Paths.get(RootPath.PATH + "/font/12905.otf");

        try {
            renderer.getFontResolver().addFont(path.toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

        try {
            config.setEncoding(Locale.ENGLISH, ENCODING);

            Template t = config.getTemplate(PDF, ENCODING);
            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("units", unitList);

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, templateModel);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream, true);
            return outputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
