package cc.anmink.service.Impl;

import cc.anmink.dao.SysArticleCategoryRepoitory;
import cc.anmink.dao.SysArticleRepoitory;
import cc.anmink.dao.SysArticleTagRepoitory;
import cc.anmink.entity.SysArticle;
import cc.anmink.entity.SysArticleCategory;
import cc.anmink.entity.SysArticleTag;
import cc.anmink.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jamin on 2017/3/11.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private SysArticleRepoitory sysArticleRepository;

    @Autowired
    private SysArticleCategoryRepoitory sysArticleCategoryRepoitory;

    @Autowired
    private SysArticleTagRepoitory sysArticleTagRepoitory;

    @Override
    public List<SysArticle> getById(Long id) {
        return sysArticleRepository.findById(id);
    }

    @Override
    public List<SysArticle> getAll() {
        return sysArticleRepository.findAll();
    }

    @Override
    public SysArticle create(String title, String caption_pic, String content, String category, String tag) {
        Long timestamp = System.currentTimeMillis();
        return sysArticleRepository.save(new SysArticle(title, caption_pic, content, category, tag, timestamp));
    }

    //根据id获取分类
    @Override
    public SysArticleCategory getCategoryById(Long id) {
        return sysArticleCategoryRepoitory.findById(id);
    }

    @Override
    public List<SysArticleCategory> getAllCategory() {
        return sysArticleCategoryRepoitory.findAll();
    }

    @Override
    public SysArticleCategory createCategory(String name) {
        Long timestamp = System.currentTimeMillis();
        return sysArticleCategoryRepoitory.save(new SysArticleCategory(name, timestamp));
    }

    @Override
    public SysArticleTag createTag(String name) {
        Long timestamp = System.currentTimeMillis();
        return sysArticleTagRepoitory.save(new SysArticleTag(name, timestamp));
    }

    @Override
    public List<SysArticleTag> getAllTag() {
        return sysArticleTagRepoitory.findAll();
    }

    @Override
    public SysArticleTag deleteTagById(Long id) {
        SysArticleTag sysArticleTag = sysArticleTagRepoitory.findById(id);
        sysArticleTagRepoitory.delete(sysArticleTag);
        return sysArticleTag;
    }
}
