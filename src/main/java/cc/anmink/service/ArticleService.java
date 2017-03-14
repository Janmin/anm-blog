package cc.anmink.service;

import cc.anmink.entity.SysArticle;
import cc.anmink.entity.SysArticleCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/11.
 */
@Repository
public interface ArticleService {

    //根据id获取单条文章
    List<SysArticle> getById(Long id);

    //获取全部文章
    List<SysArticle> getAll();

    //新建文章
    SysArticle create(String title, String caption_pic, String content, String category, String tag);

    //根据Id获取分类记录
    SysArticleCategory getCategoryById(Long id);

    //获取全部分类
    List<SysArticleCategory> getAllCategory();

    //新增分类
    SysArticleCategory createCategory(String name);
}
