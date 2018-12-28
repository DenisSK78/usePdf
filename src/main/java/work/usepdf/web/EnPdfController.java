package work.usepdf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import work.usepdf.service.EnService;


@Controller
public class EnPdfController {

    private EnService service;

    @Autowired
    public EnPdfController(EnService service) {
        this.service = service;
    }

    @GetMapping("pdf")
    private String getPdf(Model model) {
        model.addAttribute("units", service.getRandomUnits(3));
        return "pdf-example";
    }

    @GetMapping("home")
    private String getEnglishForTestSecurity(){
        return "english";
    }

}