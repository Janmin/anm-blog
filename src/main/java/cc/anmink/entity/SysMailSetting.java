package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xiezijian on 2017/5/11.
 */
@Entity
public class SysMailSetting {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String host;
    private String port;

    private String subject;
    private String text;

    public SysMailSetting() {
    }

    public SysMailSetting(String username, String password, String host, String port, String subject, String text) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.subject = subject;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
