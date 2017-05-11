package cc.anmink.entity;

import com.sun.org.apache.xpath.internal.operations.String;

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
}
