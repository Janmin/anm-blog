package cc.anmink.entity;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by xiezijian on 2017/6/22.
 */
@Entity
public class Message {
    @Id
    private Integer id;
    private String name;
    private String title;
    private String content;
    private Long created;

    public Message() {
    }

    public Message(Integer id, String name, String title, String content, Long created) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}
