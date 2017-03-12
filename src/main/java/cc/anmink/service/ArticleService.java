package cc.anmink.service;

import cc.anmink.entity.SysArticle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/11.
 */
@Repository
public interface ArticleService {
    List<SysArticle> getById(Long id);

    List<SysArticle> getAll();

    SysArticle create(String title, String caption_pic, String content, String category, String tag);
}
