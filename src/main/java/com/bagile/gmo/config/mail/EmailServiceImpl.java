package com.bagile.gmo.config.mail;

import com.bagile.gmo.dto.Notification;
import com.bagile.gmo.dto.Template;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ContactService;
import com.bagile.gmo.services.impl.MailConfigServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

@Component
public class EmailServiceImpl implements EmailService {
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MailConfigServiceImpl.class);
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private ContactService contactService;
    @Autowired
    private javax.sql.DataSource dataSource;

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to,
                                               String subject,
                                               SimpleMailMessage template,
                                               String ...templateArgs) {
        String text = String.format(template.getText(), templateArgs);  
        sendSimpleMessage(to, subject, text);
    }

    @Override
    public void sendMessageWithAttachment(String to,
                                          String subject,
                                          String text,
                                          String pathToAttachment) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            // pass 'true' to the constructor to create a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File (pathToAttachment));
            helper.addAttachment("demande-intilaka", file);

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendEmail(Notification notification, MailConfig mail, Template template) throws IdNotFound {
        String text="";
        //Contact contact=contactService.findById(notification.getC().getId());
       // DataSource attachment=pdfFile(notification,contact);;
        final String username = mail.getUsername();
        final String password = mail.getPassword();//AES.decrypt(mail.getPassword());
        String host = mail.getHost();
        String port=mail.getPort();
        String starttls=mail.getStarttlsEnable();
        String auth="true";
        String trust=mail.getTrust();

        Properties props = new Properties();
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", starttls);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.trust", trust);


        try {
            Session session = Session.getInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            MimeMessage msg = new MimeMessage(session);
            MimeMessageHelper helper = new MimeMessageHelper(msg,true);
            helper.setTo(new InternetAddress(notification.getNotificationType().getEmail()));
            helper.setFrom(new InternetAddress(username));
            helper.setSubject(template.getSubject());
            if(null != template.getText())
            {
                text=template.getText();


                if(text.contains("{code}"))
                {
                    text=text.replace("{code}",notification.getCode());
                }

                if(text.contains("{action}"))
                {
                    text=text.replace("{action}",notification.getAction());
                }
                if(text.contains("{statut}"))
                {
                    text=text.replace("{statut}",notification.getNotificationState().getCode());
                }
                if(text.contains("{vehicule}"))
                {
                    text=text.replace("{vehicule}",notification.getPatimonyCode());
                }


            }
            helper.setText(text,true);
          //  helper.addAttachment(demande.getId()+".pdf",attachment);
            Transport.send(msg);
            System.out.println("send successfully");
        } catch (Exception ex) {
            System.err.println("Error occurred while sending.!");
        }
    }

   /* private DataSource pdfFile(Demande demande, Contact contact)  {
        DataSource aAttachment=null;
        Resource report;
        try
        {
            if(null!=demande)
            {
                if(contact.getContactType().getId() == 1)
                    report=new ClassPathResource("intilaka.jrxml");
                if(contact.getContactType().getId() == 2)
                    report=new ClassPathResource("intilakaSalarie.jrxml");
                else
                    report=new ClassPathResource("intilakaEntrepreneur.jrxml");
                Connection connection = dataSource.getConnection();
                JasperReport jasperReport = JasperCompileManager.compileReport(report.getInputStream());
                Map parameters = new HashMap<>();
                Locale locale = Locale.ENGLISH;
                Resource bundlePath=new ClassPathResource("intilakaLabel.properties");
                ResourceBundle bundle = new PropertyResourceBundle(bundlePath.getInputStream());
                parameters.put(JRParameter.REPORT_LOCALE, locale);
                parameters.put(JRParameter.REPORT_RESOURCE_BUNDLE, bundle);
                parameters.put("id", demande.getId());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
                aAttachment =  new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
                return aAttachment;
            }
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        return aAttachment;
    }*/

}