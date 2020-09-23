package org.daxue.service.common;

import lombok.extern.slf4j.Slf4j;
import org.daxue.config.MailConfig;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

@Slf4j
@Service
public class MailSendServiceImpl implements MailSendService{

    @Override
    public boolean send(String recipient, String subject, String content) {

        try {
            // 1. 创建一封邮件
            Properties props = new Properties();// 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
            props.setProperty("mail.smtp.host", MailConfig.MAIL_QQ_HOST);//发送邮箱服务器
            props.setProperty("mail.smtp.port",MailConfig.MAIL_QQ_PORT);//发送端口

            props.setProperty("mail.smtp.auth","true");//是否开启权限控制
            props.setProperty("mail.debug","true");//true 打印信息到控制台
            props.setProperty("mail.transport","smtp");//发送的协议是简单的邮件传输协议
            props.setProperty("mail.smtp.ssl.enable","true");


            Session session= Session.getInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MailConfig.SEND_USERNAME,MailConfig.SEND_PASSWORD);
                }
            });        // 根据参数配置，创建会话对象（为了发送邮件准备的）
            MimeMessage message = new MimeMessage(session);     // 创建邮件对象

            /*
             * 也可以根据已有的eml邮件文件创建 MimeMessage 对象
             * MimeMessage message = new MimeMessage(session, new FileInputStream("myEmail.eml"));
             */

            // 2. From: 发件人
            //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
            //    真正要发送时, 邮箱必须是真实有效的邮箱。
            message.setFrom(new InternetAddress(MailConfig.SEND_USERNAME, "tools_site", "UTF-8"));

            // 3. To: 收件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipient, "网站消息提醒", "UTF-8"));
//        //    To: 增加收件人（可选）
//        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
//        //    Cc: 抄送（可选）
//        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
//        //    Bcc: 密送（可选）
//        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));

            // 4. Subject: 邮件主题
            message.setSubject(subject, "UTF-8");

            // 5. Content: 邮件正文（可以使用html标签）
            message.setContent(content, "text/html;charset=UTF-8");

            // 6. 设置显示的发件时间
            message.setSentDate(new Date());

            // 7. 保存前面的设置
            message.saveChanges();

            Transport transport = session.getTransport();
            transport.connect(MailConfig.SEND_USERNAME, MailConfig.SEND_PASSWORD);
            Transport.send(message);
            log.error("MailSendServiceImpl send: success , maybe write file is error!");


            // 8. 将该邮件保存到本地
            OutputStream out = new FileOutputStream("/Users/daxue0929/upload/testEmail.eml");
            message.writeTo(out);
            out.flush();
            out.close();
            return true;
        } catch (MessagingException | IOException e) {
            log.error("MailSendServiceImpl send: {}", e.getMessage());
            return false;
        }
    }
}
