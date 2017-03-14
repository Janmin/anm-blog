package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jamin on 2017/3/13.
 */
@Entity
public class SysArticleCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long created;

    public SysArticleCategory() {
    }

    public SysArticleCategory(String name, Long created) {
        this.name = name;
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

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}
