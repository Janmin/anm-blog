package cc.anmink.dao;

import cc.anmink.entity.SysArticle;
import cc.anmink.entity.SysArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/13.
 */
public interface SysArticleCategoryRepoitory extends JpaRepository<SysArticleCategory, Long>{
    //通过id获取单行记录
    SysArticleCategory findById(Long id);

    //获取全部记录
    List<SysArticleCategory> findAll();
}
