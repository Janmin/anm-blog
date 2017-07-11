package cc.anmink.service;

import cc.anmink.entity.SysArticle;
import cc.anmink.entity.SysArticleCategory;
import cc.anmink.entity.SysArticleTag;
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
    SysArticle create(String title, String caption_pic, String content, SysArticleCategory category, String tag);

    //根据Id获取分类记录
    SysArticleCategory getCategoryById(Long id);

    //根据id获取对应的tag
    String getTagById(Long id);

    //获取全部分类
    List<SysArticleCategory> getAllCategory();

    //新增分类
    SysArticleCategory createCategory(String name);

    //新增标签
    SysArticleTag createTag(String name);

    //获取全部标签
    List<SysArticleTag> getAllTag();

    //根据id删除标签
    SysArticleTag deleteTagById(Long id);

    //更新文章
    int updateAll(String title, String caption_pic, String content, SysArticleCategory category, String tag, Long id);
}
