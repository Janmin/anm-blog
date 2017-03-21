package cc.anmink.service.Impl;

import cc.anmink.dao.SysAlbumPicRepoitory;
import cc.anmink.dao.SysAlbumRepoitory;
import cc.anmink.dao.SysAlbumTagRepoitory;
import cc.anmink.entity.SysAlbum;
import cc.anmink.entity.SysAlbumPic;
import cc.anmink.entity.SysAlbumTag;
import cc.anmink.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.List;

/**
 * Created by Jamin on 2017/3/19.
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    SysAlbumRepoitory sysAlbumRepoitory;

    @Autowired
    SysAlbumPicRepoitory sysAlbumPicRepoitory;

    @Autowired
    SysAlbumTagRepoitory sysAlbumTagRepoitory;

    @Override
    public List<SysAlbum> getAll() {
        return sysAlbumRepoitory.findAll();
    }

    @Override
    public SysAlbum create(String name, String intro, String tags) {
        Long timestamp = System.currentTimeMillis();
        SysAlbum sysAlbum = new SysAlbum(name, intro, "", tags, timestamp);
        return sysAlbumRepoitory.save(sysAlbum);
    }

    @Override
    public SysAlbum getById(Long id) {
        return sysAlbumRepoitory.findById(id);
    }

    @Override
    public SysAlbumPic create(String link, Long album) {
        Long timestamp = System.currentTimeMillis();
        return sysAlbumPicRepoitory.save(new SysAlbumPic(link,album,timestamp));
    }

    @Override
    public List<SysAlbumPic> getByAlbum(Long album) {
        return sysAlbumPicRepoitory.findByAlbum(album);
    }

    @Override
    public List<SysAlbumTag> getAllTag() {
        return sysAlbumTagRepoitory.findAll();
    }

    @Override
    public SysAlbumTag createTag(String name) {
        Long timestamp = System.currentTimeMillis();
        return sysAlbumTagRepoitory.save(new SysAlbumTag(name, timestamp));
    }
}
