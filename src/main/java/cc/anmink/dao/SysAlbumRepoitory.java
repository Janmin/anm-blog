package cc.anmink.dao;

import cc.anmink.entity.SysAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/19.
 */
public interface SysAlbumRepoitory extends JpaRepository<SysAlbum,Long> {
    List<SysAlbum> findAll();

    SysAlbum findById(Long id);
}
