package cc.anmink.service;

import cc.anmink.entity.SysAlbum;
import cc.anmink.entity.SysAlbumPic;
import cc.anmink.entity.SysAlbumTag;
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

    //新增照片
    SysAlbumPic create(String link, Long album);

    //根据album_id获取照片
    List<SysAlbumPic> getByAlbum(Long album);

    //获取tag list
    List<SysAlbumTag> getAllTag();

    //新增ALBUM TAG
    SysAlbumTag createTag(String name);
}
