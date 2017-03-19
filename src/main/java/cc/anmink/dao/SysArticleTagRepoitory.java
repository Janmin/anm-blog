package cc.anmink.dao;

import cc.anmink.entity.SysArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/18.
 */
public interface SysArticleTagRepoitory extends JpaRepository<SysArticleTag, Long> {
    //获取全部
    List<SysArticleTag> findAll();

    //根据id查找纪录
    SysArticleTag findById(Long id);
}
