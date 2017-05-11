package cc.anmink.dao;

import cc.anmink.entity.SysSmsSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jamin on 2017/5/5.
 */
public interface SysSmsSettingRepoitory extends JpaRepository<SysSmsSetting, Long> {
    SysSmsSetting findById(Long id);
}
