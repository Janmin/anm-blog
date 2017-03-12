package cc.anmink.service.Impl;

import cc.anmink.dao.SysSettingRepoitory;
import cc.anmink.entity.SysSetting;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jamin on 2017/3/11.
 */
@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    private SysSettingRepoitory sysSettingRepoitory;

    @Override
    public List<SysSetting> getAll() {
        return sysSettingRepoitory.findAll();
    }

    @Override
    public SysSetting getById() {
        return sysSettingRepoitory.findById((long) 1);
    }

    @Override
    public int update(String count_code, String copy_right, String description, String icp, Integer site_status, Long id) {
        return sysSettingRepoitory.updateAllById(count_code, copy_right, description, icp, site_status, id);
    }


}
