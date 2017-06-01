package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xiezijian on 2017/5/30.
 */
@Entity
public class SysMessage {
    @Id
    @GeneratedValue
    private Long id;
    private Long user_id;
    private Long article_id;
    private String content;
    private Long created;

    public SysMessage() {

    }

    public SysMessage(Long user_id, Long article_id, String content, Long created) {
        this.user_id = user_id;
        this.article_id = article_id;
        this.content = content;
        this.created = created;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
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
