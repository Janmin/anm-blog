package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jamin on 2017/3/19.
 */
@Entity
public class SysAlbum {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String intro;
    private String cover;
    private String tags;
    private Long created;

    public SysAlbum() {
    }

    public SysAlbum(String name, String intro, String cover, String tags, Long created) {
        this.name = name;
        this.intro = intro;
        this.cover = cover;
        this.tags = tags;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}
