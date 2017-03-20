package cc.anmink.dao;

import cc.anmink.entity.SysAlbumPic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/20.
 */
public interface SysAlbumPicRepoitory extends JpaRepository<SysAlbumPic, Long>{
    //根据album_id获取数据
    List<SysAlbumPic> findByAlbum(Long album);
}
