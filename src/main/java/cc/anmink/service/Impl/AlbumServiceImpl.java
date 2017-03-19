package cc.anmink.service.Impl;

import cc.anmink.dao.SysAlbumRepoitory;
import cc.anmink.entity.SysAlbum;
import cc.anmink.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jamin on 2017/3/19.
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    SysAlbumRepoitory sysAlbumRepoitory;

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
}
