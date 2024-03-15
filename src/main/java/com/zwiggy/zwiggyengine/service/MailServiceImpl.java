package com.zwiggy.zwiggyengine.service;

import com.zwiggy.zwiggyengine.constant.AppConstant;
import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.exception.EmailDeliveryException;
import com.zwiggy.zwiggyengine.model.MailRequestBody;
import freemarker.template.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import java.util.Map;

/**
 * Implementation of the {@link MessageService} interface for sending emails using JavaMailSender.
 * This class is annotated with {@code @Service} to indicate that it is a Spring service bean.
 *
 * <p>The email sending functionality is implemented in the {@link #send(Object)} method, which takes
 * a {@link MailRequestBody} object as the message content and sends an email based on the provided details.
 * The email content is generated using a FreeMarker template specified in the configuration.
 *
 * <p>The class uses the {@link JavaMailSender} for sending emails and has dependencies injected
 * for the {@link JavaMailSender} and {@link Configuration} beans. The sender's username is also injected
 * using the {@code @Value} annotation.
 *
 * <p>Additionally, the class provides a utility method {@link #createMailRequest(String)} for creating
 * a {@link MailRequestBody} object from a formatted request string.
 *
 * @author piyush
 * @version 1.0
 * @since 2024-03-07
 */
@Service
@Slf4j
public class MailServiceImpl implements MessageService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration config;

    @Value("${spring.mail.username}")
    private String emailFrom;

    /**
     * Creates a {@link MailRequestBody} object from a formatted request string.
     *
     * @param request The formatted request string containing information about the email.
     * @return A {@link MailRequestBody} object representing the email details.
     */
    public MailRequestBody createMailRequest(String request){
        String[] content = request.split(AppConstant.DASH);
        return MailRequestBody.builder()
                .username(content[1])
                .to(content[0])
                .from(emailFrom)
                .subject(content[2])
                .build();
    }

    /**
     * Sends a simple email message based on the provided {@link MailRequestBody} content.
     *
     * @param messageContent The {@link MailRequestBody} object representing the email content.
     * @return A string representing the result or status of the email sending operation.
     * @throws EmailDeliveryException If there is an issue with sending the email.
     */
    @Override
    public String send(Object messageContent) throws EmailDeliveryException {
        MailRequestBody mrb = (MailRequestBody) messageContent;
        MimeMessage message = sender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

//            helper.addAttachment(AppConstant.EMAILBANNER, new ClassPathResource("EmailBanner.jpg"));
            Map<String, String> model = new HashMap<>();
            model.put(AppConstant.USER,mrb.getUsername());
            System.getProperty("java.class.path");
            Template t = config.getTemplate("EmailTemplate.ftl");

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            helper.setTo(mrb.getTo());
            helper.setText(html, true);
            helper.setSubject(mrb.getSubject());
            helper.setFrom(mrb.getFrom());
            sender.send(message);

        } catch (MessagingException | IOException | TemplateException e) {
            log.error(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.EMAILERROR), e.getCause());
            throw new EmailDeliveryException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.EMAILERROR));
        }
        return AppConstant.SUCCESS;
    }

}
