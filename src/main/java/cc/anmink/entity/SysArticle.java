package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jamin on 2017/3/11.
 */
@Entity
public class SysArticle {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String caption_pic;
    private String content;
    private String category;
    private String tag;
    private Long created;

    public SysArticle() {
    }

    public SysArticle(String title, String caption_pic, String content, String category, String tag, Long created) {
        this.title = title;
        this.caption_pic = caption_pic;
        this.content = content;
        this.category = category;
        this.tag = tag;
        this.created = created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCaption_pic(String caption_pic) {
        this.caption_pic = caption_pic;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCaption_pic() {
        return caption_pic;
    }

    public String getContent() {
        return content;
    }

    public Long getCreated() {
        return created;
    }
}
