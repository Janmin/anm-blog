package cc.anmink.service;

import cc.anmink.entity.SysAlbum;
import cc.anmink.entity.SysArticle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/19.
 */
@Repository
public interface AlbumService {
    //获取相册列表
    List<SysAlbum> getAll();

    //新增相册
    SysAlbum create(String name,String intro,String tags);

    //获取相册信息
    SysAlbum getById(Long id);
}
