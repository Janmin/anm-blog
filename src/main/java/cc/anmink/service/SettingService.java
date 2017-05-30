package cc.anmink.service;

import cc.anmink.entity.SysMailSetting;
import cc.anmink.entity.SysSetting;
import cc.anmink.entity.SysSmsSetting;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/11.
 */
@Repository
public interface SettingService {
    List<SysSetting> getAll();

    SysSetting getById();

    int updateAllById(String count_code, String copy_right, String description, String icp, Integer site_status, Long id);

    SysSmsSetting getSmsById(Long id);

    int updateSms(String url, String username, String password, String content);

    SysMailSetting getMailById();

    int updateMailSetting(String host, String port, String subject, String text, String username, String password);
}
