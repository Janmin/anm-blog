package cc.anmink.service.Impl;

import cc.anmink.dao.SysArticleRepoitory;
import cc.anmink.entity.SysArticle;
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
        Long timestamp = System.currentTimeMillis() / 1000;
        return sysArticleRepository.save(new SysArticle(title, caption_pic, content, category, tag, timestamp));
    }
}
