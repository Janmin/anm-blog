package cc.anmink.web;

import cc.anmink.entity.SysArticle;
import cc.anmink.entity.SysArticleCategory;
import cc.anmink.entity.SysArticleTag;
import cc.anmink.entity.SysSetting;
import cc.anmink.baseServe.MyResponse;
import cc.anmink.service.ArticleService;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * Created by Jamin on 2017/3/11.
 */
@Controller
public class ArticleController {

    private SysSetting sysSetting;

    @Autowired
    ArticleService articleService;
    @Autowired
    SettingService settingService;

    @Autowired
    public void getSetting() {
        this.sysSetting = settingService.getById();
    }

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
    public MyResponse add(String title, String caption_pic, String content, Long category_id, String tag) {

        SysArticleCategory sysArticleCategory = articleService.getCategoryById(category_id);

        SysArticle sysArtices = articleService.create(title, caption_pic, content, sysArticleCategory, tag);
        MyResponse json = new MyResponse<SysArticle>(200, "success", sysArtices);
        return json;
    }

    //后台文章列表页面Controller
    @RequestMapping("/admin/article/list")
    public String articles(Map map) {
        List<SysArticle> sysArtices = articleService.getAll();
        map.put("sys_info", sysSetting);
        map.put("lists", sysArtices);
        return "admin/article-list";
    }

    //后台文章编辑页面Controller
    @RequestMapping("/admin/article/edit")
    public String edit(Long id, Map map) {
        List<SysArticle> sysArtices = articleService.getById(id);
        List<SysArticleCategory> sysArticleCategories = articleService.getAllCategory();
        List<SysArticleTag> sysArticleTags = articleService.getAllTag();
        map.put("tags", sysArticleTags);
        map.put("categories", sysArticleCategories);
        map.put("id", id);
        map.put("sys_info", sysSetting);
        map.put("article", sysArtices.get(0));
        return "admin/article-detail";
    }

    @RequestMapping("/api/article/tag/detail")
    @ResponseBody
    public String[] getArticleTag(Long id) {
        String tag = articleService.getTagById(id);
        tag = tag.replace("[", "");
        tag = tag.replace("]", "");
        tag = tag.replace("\"", "");
        String[] arrays = tag.split(",");
        return arrays;
    }

    //后台文章分类管理页面Controller
    @RequestMapping("/admin/article/category/list")
    public String getCategory(Map map) {
        List<SysArticleCategory> sysArticleCategories = articleService.getAllCategory();
        map.put("sys_info", sysSetting);
        map.put("lists", sysArticleCategories);
        return "admin/article-category";
    }

    @RequestMapping("/api/article/category/add")
    @ResponseBody
    public MyResponse addArticleCategory(String name) {
        try {
            SysArticleCategory sysArticleCategory = articleService.createCategory(name);
            return new MyResponse<SysArticleCategory>(200, "success", sysArticleCategory);
        } catch (Exception e) {
            return new MyResponse<Null>(200, "fail", null);
        }
    }

    //后台文章标签管理页面
    @RequestMapping("/admin/article/tag/list")
    public String articleTagList(Map map) {
        List<SysArticleTag> sysArticleTags = articleService.getAllTag();
        map.put("lists", sysArticleTags);
        map.put("sys_info", sysSetting);
        return "admin/article-tag";
    }

    //后台文章标签新增接口
    @RequestMapping("/api/article/tag/add")
    @ResponseBody
    public MyResponse articleTagAdd(String name) {
        try {
            SysArticleTag sysArticleTag = articleService.createTag(name);
            return new MyResponse<SysArticleTag>(200, "success", sysArticleTag);
        } catch (Exception e) {
            return new MyResponse<Null>(400, "fail", null);
        }
    }

    //后台文章标签新增接口
    @RequestMapping("/api/article/tag/del")
    @ResponseBody
    public MyResponse articleTagDel(Long id) {
        try {
            SysArticleTag sysArticleTag = articleService.deleteTagById(id);
            return new MyResponse<SysArticleTag>(200, "success", sysArticleTag);
        } catch (Exception e) {
            return new MyResponse<Null>(400, "fail", null);
        }
    }

    @RequestMapping("/admin/article/add")
    public String articleAdd(Map map) {
        List<SysArticleCategory> sysArticleCategories = articleService.getAllCategory();
        List<SysArticleTag> sysArticleTags = articleService.getAllTag();
        map.put("categories", sysArticleCategories);
        map.put("tags", sysArticleTags);
        map.put("sys_info", this.sysSetting);
        return "admin/article-add";
    }

    @RequestMapping(value = "/api/article/edit", method = RequestMethod.POST)
    @ResponseBody
    public MyResponse doEdit(String title, String caption_pic, String content, Long category_id, String tag, Long id) {
        SysArticleCategory sysArticleCategory = articleService.getCategoryById(category_id);
        try {
            Integer integer = articleService.updateAll(title, caption_pic, content, sysArticleCategory, tag, id);
            MyResponse json = new MyResponse<>(200, "success", null);
            return json;
        } catch (Exception e) {
            MyResponse json = new MyResponse<>(400, "fail", null);
            return json;
        }
    }
}
