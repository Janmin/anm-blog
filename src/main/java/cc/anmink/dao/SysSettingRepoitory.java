package cc.anmink.dao;

import cc.anmink.entity.SysSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Jamin on 2017/3/11.
 */
public interface SysSettingRepoitory extends JpaRepository<SysSetting, Long> {
    List<SysSetting> findAll();

    SysSetting findById(Long id);

    @Modifying
    @Transactional
    @Query("update SysSetting s set s.count_code =?1,s.copy_right=?2,s.description=?3,s.icp=?4,s.site_status=?5 where s.id = ?6")
    int updateAllById(String count_code, String copy_right, String description, String icp, Integer site_status, Long id);
}
