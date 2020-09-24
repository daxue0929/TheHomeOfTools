package org.daxue.service.common;

public interface MailSendService {

    /**
     * @param recipient 收件人邮箱地址 eg: 3261236160@qq.com
     * @param subject 邮件主题
     * @param content 邮件正文
     *
     * @return 发送成功返回 true
     */
    boolean send(String recipient, String subject, String content);
}
