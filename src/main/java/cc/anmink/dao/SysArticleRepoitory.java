package cc.anmink.dao;

import cc.anmink.entity.SysArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/11.
 */
public interface SysArticleRepoitory extends JpaRepository<SysArticle, Long> {
    List<SysArticle> findById(Long id);
}
