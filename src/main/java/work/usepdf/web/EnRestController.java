package work.usepdf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.usepdf.object.MailRequest;
import work.usepdf.object.MailResponse;
import work.usepdf.object.Unit;
import work.usepdf.service.EmailService;
import work.usepdf.service.EnService;

import java.util.List;

@CrossOrigin
@RestController
public class EnRestController {

    private EnService service;

    private final EmailService eService;

    @Autowired
    public EnRestController(EnService service, EmailService eService) {
        this.service = service;
        this.eService = eService;
    }

    @GetMapping("learned")
    private List<Unit> getThreeUnits(){
        return service.getRandomUnits(3);
    }

    @PostMapping("/send-email")
    public MailResponse sendEmail(@RequestBody MailRequest request){
//        Map<String, Object> model = new HashMap<>();
//        model.put("Name", "Den");
//        model.put("location", "Minsk, BY");
        return eService.sendEmail(request);
    }

}
