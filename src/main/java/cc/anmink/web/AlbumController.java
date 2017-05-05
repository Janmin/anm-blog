package cc.anmink.web;

import cc.anmink.entity.SysAlbum;
import cc.anmink.entity.SysAlbumPic;
import cc.anmink.entity.SysAlbumTag;
import cc.anmink.baseServe.MyResponse;
import cc.anmink.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;
import java.io.*;
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
        map.put("info", sysAlbum);
        return "admin/album-detail";
    }

    //后台相册标签列表
    @RequestMapping("/admin/album/tag/list")
    public String albumCategoryList(Map map) {
        List<SysAlbumTag> sysAlbumTags = albumService.getAllTag();
        map.put("lists", sysAlbumTags);
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

    //新增album tag接口
    @RequestMapping(value = "/api/album/tag/add",method = RequestMethod.POST)
    @ResponseBody
    public MyResponse albumTagAdd(String name){
        try {
            SysAlbumTag sysAlbumTag = albumService.createTag(name);
            return new MyResponse(200, "success", sysAlbumTag);
        }catch (Exception e){
            return new MyResponse<Null>(400, "fail", null);
        }
    }

    @RequestMapping("/admin/album/upload")
    @ResponseBody
    public MyResponse handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String new_file_name = System.currentTimeMillis() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("E:\\WorkSpace\\anm-blog\\src\\main\\resources\\static\\uploads\\" + new_file_name)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new MyResponse<Null>(400, e.getMessage(), null);
            } catch (IOException e) {
                e.printStackTrace();
                return new MyResponse<Null>(400, e.getMessage(), null);
            }
            String url = "/uploads/" + new_file_name;
            return new MyResponse<String>(200, "success", url);
        } else {
            return new MyResponse<Null>(400, "fail", null);
        }
    }

}
