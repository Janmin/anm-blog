package cc.anmink.dao;

import cc.anmink.entity.SysMailSetting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiezijian on 2017/5/11.
 */
public interface SysMailSettingRepoitory extends JpaRepository<SysMailSetting, Long> {
}
