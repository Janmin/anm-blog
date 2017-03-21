package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xiezijian on 2017/3/21.
 */
@Entity
public class SysAlbumTag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long created;

    public SysAlbumTag() {
    }

    public SysAlbumTag(String name, Long created) {
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
