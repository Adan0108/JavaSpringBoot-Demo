package com.adan108.service;

import com.adan108.entity.mail.EmailEntity;

public interface EmailService {
    String sendTextEmail(EmailEntity email);
    String sendHtmlEmail(EmailEntity email);
    String sendMailAttachmentEmail(EmailEntity email);
}
