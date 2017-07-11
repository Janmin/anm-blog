package cc.anmink.dao;

import cc.anmink.entity.SysArticle;
import cc.anmink.entity.SysArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Jamin on 2017/3/11.
 */
public interface SysArticleRepoitory extends JpaRepository<SysArticle, Long> {
    List<SysArticle> findById(Long id);

    @Query(value = "select sa.tag from SysArticle sa where sa.id = ?1")
    String findTagById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update SysArticle sa set sa.title = ?1,sa.caption_pic =?2,sa.content=?3,sa.category = ?4,sa.tag = ?5 where sa.id = ?6")
    int updateAll(String title, String caption_pic, String content, SysArticleCategory category, String tag, Long id);
}
