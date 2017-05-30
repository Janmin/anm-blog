package cc.anmink.dao;

import cc.anmink.entity.SysMailSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xiezijian on 2017/5/11.
 */
public interface SysMailSettingRepoitory extends JpaRepository<SysMailSetting, Long> {

    SysMailSetting findById(Long id);

    List<SysMailSetting> findAll();

    @Modifying
    @Transactional
    @Query("update SysMailSetting s set s.host =?1,s.port=?2,s.subject=?3,s.text=?4,s.username=?5,s.password=?6 where s.id = ?7")
    int updateAllById(String host, String port, String subject, String text, String username, String password, Long id);
}
