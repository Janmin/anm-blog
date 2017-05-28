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
    @Query("update SysSmsSetting s set s.url =?2,s.username=?3,s.password=?4,s.icp=?4,s.content=?5 where s.id = ?1")
    int updateSmsById(Long id, String url, String username, String password, String content);
}
