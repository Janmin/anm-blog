package cc.anmink.web;

import cc.anmink.entity.SysAlbum;
import cc.anmink.entity.SysAlbumPic;
import cc.anmink.responese.MyResponse;
import cc.anmink.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

/**
 * Created by Jamin on 2017/3/19.
 */
@Controller
public class AlbumController {
    @Autowired
    AlbumService albumService;

    //后台相册列表
    @RequestMapping("/admin/album/list")
    public String albumList(Map map) {
        List<SysAlbum> sysAlbums = albumService.getAll();
        map.put("lists", sysAlbums);
        return "admin/album-list";
    }

    //后台相册详情页面
    @RequestMapping("/admin/album/detail")
    public String albumDetail(Map map, long id) {
        List<SysAlbumPic> sysAlbumPics = albumService.getByAlbum(id);
        SysAlbum sysAlbum = albumService.getById(id);
        map.put("lists", sysAlbumPics);
        map.put("info",sysAlbum);
        return "admin/album-detail";
    }

    //后台相册标签列表
    @RequestMapping("/admin/album/tag/list")
    public String albumCategoryList() {
        return "admin/album-tag";
    }

    //后台新增相册接口
    @RequestMapping("/api/album/add")
    @ResponseBody
    public MyResponse albumAdd(String name, String intro, String tags) {
        try {
            SysAlbum sysAlbum = albumService.create(name, intro, tags);
            return new MyResponse<SysAlbum>(200, "success", sysAlbum);
        } catch (Exception e) {
            return new MyResponse<Null>(400, "fail", null);
        }
    }

    //根据id获取相册信息的接口
    @RequestMapping("/api/album/get")
    @ResponseBody
    public MyResponse albumGet(Long id) {
        try {
            SysAlbum sysAlbum = albumService.getById(id);
            return new MyResponse<SysAlbum>(200, "success", sysAlbum);
        } catch (Exception e) {
            return new MyResponse<Null>(400, "fail", null);
        }
    }

}
