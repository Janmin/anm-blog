package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jamin on 2017/3/16.
 */
@Entity
public class SysArticleTag {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long created;

    public SysArticleTag() {
    }

    public SysArticleTag(String name, Long created) {
        this.name = name;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCreated() {
        return created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}
