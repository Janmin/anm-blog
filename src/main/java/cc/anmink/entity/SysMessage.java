package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by xiezijian on 2017/5/30.
 */
@Entity
public class SysMessage {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private SysUser user;
    @ManyToOne
    private SysArticle article;
    private String content;
    private Long created;

    public SysMessage() {

    }

    public SysMessage(SysUser user, SysArticle article, String content, Long created) {
        this.user = user;
        this.article = article;
        this.content = content;
        this.created = created;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public SysArticle getArticle() {
        return article;
    }

    public void setArticle(SysArticle article) {
        this.article = article;
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
