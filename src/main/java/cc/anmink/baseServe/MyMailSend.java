package cc.anmink.baseServe;

import org.springframework.core.io.UrlResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.activation.URLDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

/**
 * Created by xiezijian on 2017/5/11.
 */
public class MyMailSend {

    private static JavaMailSender createJavaMailSender(String username, String password, String host, String port) {
        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");// 是否显示调试信息(可选)
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.auth", "true");

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setHost(host);
        javaMailSender.setPort(465);
        javaMailSender.setDefaultEncoding("UTF-8");
        return javaMailSender;
    }

    /**
     * @descrption SimpleMailMessage发送简单邮件
     */
    public static void sendSimpleMailMessage(String username, String password, String host, String port, String from, String to, String subject, String text) {
        JavaMailSender javaMailSender = createJavaMailSender(username, password, host, port);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);// 发送者，可选的
        mailMessage.setTo(to);//接受者
        mailMessage.setSubject(subject);//主题
        mailMessage.setText(text + new Date());//邮件内容

        javaMailSender.send(mailMessage);
    }

    /**
     * @descrption MimeMessage发送MIME类型邮件
     */
    public static void sendMimeMailMessage(String username, String password, String host, String port, String from, String to, String subject, String text) throws MessagingException, UnsupportedEncodingException {
        JavaMailSender javaMailSender = createJavaMailSender(username, password, host, port);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        // 可选的，可以用来修改显示给接收者的名字
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);

        javaMailSender.send(mimeMessage);
    }

    /**
     * @descrption 发送含附件的邮件
     */
//    public static void sendMimeMailMessageAttachment() throws MessagingException, UnsupportedEncodingException,
//            MalformedURLException {
//        JavaMailSender javaMailSender = createJavaMailSender();
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        // 第二个参数设置为true，表示允许添加附件
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setTo("790419465@qq.com");
//        helper.setSubject("发送含图片附件的邮件");
//        // 第二个参数为true表示需要内容为HTML格式
//        helper.setText("<h1>Hello</h1>", true);
//        // 需要对文件名进行转码
//        helper.addAttachment(MimeUtility.encodeText("xdwang.jpg"), new File("E:\\软件大赛.jpg"));
//        helper.addAttachment(MimeUtility.encodeText("baidu.gif"), new URLDataSource(new URL(
//                "http://www.baidu.com/img/shouye_b5486898c692066bd2cbaeda86d74448.gif")));
//
//        javaMailSender.send(mimeMessage);
//    }

    /**
     * @descrption 发送HTML格式含图片的邮件
     */
//    public static void sendMimeMailMessageInline() throws MessagingException, MalformedURLException {
//        JavaMailSender javaMailSender = createJavaMailSender();
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        // 第二个参数设置为true，表示允许添加附件
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setTo("790419465@qq.com");
//        helper.setSubject("发送含图片附件的邮件");
//        // 第二个参数为true表示需要内容为HTML格式
//        helper.setText("<h1>Hello</h1><br><img src='cid:fileId'><img src='cid:abc'>", true);
//        helper.addInline("fileId", new File("E:\\软件大赛.jpg"));
//        helper.addInline("abc", new UrlResource("http://www.baidu.com/img/shouye_b5486898c692066bd2cbaeda86d74448.gif"));
//
//        javaMailSender.send(mimeMessage);
//    }
}
