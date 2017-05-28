package cc.anmink.dao;

import cc.anmink.entity.SysSmsSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Jamin on 2017/5/5.
 */
public interface SysSmsSettingRepoitory extends JpaRepository<SysSmsSetting, Long> {
    SysSmsSetting findById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE SysSmsSetting s SET s.url =?1,s.username=?2,s.password=?3,s.content=?4 WHERE s.id = ?5")
    int updateSmsById(String url, String username, String password, String content, Long id);
}
