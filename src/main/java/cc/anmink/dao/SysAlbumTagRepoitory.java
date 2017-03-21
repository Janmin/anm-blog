package cc.anmink.dao;

import cc.anmink.entity.SysAlbumTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xiezijian on 2017/3/21.
 */
public interface SysAlbumTagRepoitory extends JpaRepository<SysAlbumTag,Long> {
    List<SysAlbumTag> findAll();
}
