package work.usepdf.service;

import work.usepdf.object.MailRequest;
import work.usepdf.object.MailResponse;

public interface EmailService {

    MailResponse sendEmail(MailRequest request);
}
