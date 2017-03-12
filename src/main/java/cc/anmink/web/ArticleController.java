package cc.anmink.web;

import cc.anmink.entity.SysArticle;
import cc.anmink.responese.MyResponse;
import cc.anmink.service.ArticleService;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Jamin on 2017/3/11.
 */
@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    SettingService settingService;

    //根据id获取单篇文章API
    @RequestMapping("/api/article/get")
    @ResponseBody
    public List<SysArticle> get(Long id) {
        List<SysArticle> sysArtices = articleService.getById(id);
        return sysArtices;
    }

    //新增文章API
    @RequestMapping(value = "/api/article/add", method = RequestMethod.POST)
    @ResponseBody
    public MyResponse add(String title, String caption_pic, String content, String category, String tag) {
        SysArticle sysArtices = articleService.create(title, caption_pic, content, category, tag);
        MyResponse json = new MyResponse<SysArticle>(200, "success", sysArtices);
        return json;
    }

    //后台文章列表页面Controller
    @RequestMapping("/admin/article/list")
    public String articles(Map map) {
        List<SysArticle> sysArtices = articleService.getAll();
        map.put("lists", sysArtices);
        return "admin/article-list";
    }

    //后台文章编辑页面Controller
    @RequestMapping("/admin/article/edit")
    public String edit(Long id, Map map) {
        List<SysArticle> sysArtices = articleService.getById(id);
        map.put("article", sysArtices.get(0));
        return "admin/article-detail";
    }

    @RequestMapping("/admin/test")
    @ResponseBody
    public int getSetting(String count_code, String copy_right, String description, String icp, Integer site_status) {
        // SysSetting sysSetting = baseService.getById();
        // return sysSetting;
        return settingService.update(count_code, copy_right, description, icp, site_status, (long) 1);
    }
}
