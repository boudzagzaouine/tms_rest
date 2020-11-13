package com.bagile.gmo.config.mail;

import com.bagile.gmo.dto.Notification;
import com.bagile.gmo.entities.Template;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text);
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        SimpleMailMessage template,
                                        String... templateArgs);
    void sendMessageWithAttachment(String to,
                                   String subject,
                                   String text,
                                   String pathToAttachment);

    void sendEmail(Notification notification, MailConfig mail, Template template) throws IdNotFound;
}