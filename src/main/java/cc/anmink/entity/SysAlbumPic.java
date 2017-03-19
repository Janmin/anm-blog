package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jamin on 2017/3/19.
 */
@Entity
public class SysAlbumPic {
    @Id
    @GeneratedValue
    private Long id;
    private String link;
    private Long album;
    private Long created;

    public SysAlbumPic() {
    }

    public SysAlbumPic(String link, Long album, Long created) {
        this.link = link;
        this.album = album;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getAlbum() {
        return album;
    }

    public void setAlbum(Long album) {
        this.album = album;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}
