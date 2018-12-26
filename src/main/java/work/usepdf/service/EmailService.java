package work.usepdf.service;

import work.usepdf.model.MailRequest;
import work.usepdf.model.MailResponse;

public interface EmailService {

    MailResponse sendEmail(MailRequest request);
}
