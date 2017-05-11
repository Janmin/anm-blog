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

<<<<<<< HEAD
    SysSmsSetting getSmsById(Long id);
=======
    SysMailSetting getMailById();
>>>>>>> cb66d05212e1c01a4adfa0399a27117e27011630
}
