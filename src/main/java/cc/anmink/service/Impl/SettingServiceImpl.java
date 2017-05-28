package cc.anmink.service.Impl;

import cc.anmink.dao.SysMailSettingRepoitory;
import cc.anmink.dao.SysSettingRepoitory;
import cc.anmink.dao.SysSmsSettingRepoitory;
import cc.anmink.entity.SysMailSetting;
import cc.anmink.entity.SysSetting;
import cc.anmink.entity.SysSmsSetting;
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

    @Autowired
    private SysSmsSettingRepoitory sysSmsSettingRepoitory;

    @Autowired
    private SysMailSettingRepoitory sysMailSettingRepoitory;

    @Override
    public List<SysSetting> getAll() {
        return sysSettingRepoitory.findAll();
    }

    @Override
    public SysSetting getById() {
        return sysSettingRepoitory.findById((long) 1);
    }

    @Override
    public int updateAllById(String count_code, String copy_right, String description, String icp, Integer site_status, Long id) {
        return sysSettingRepoitory.updateAllById(count_code, copy_right, description, icp, site_status, id);
    }

    @Override
    public SysSmsSetting getSmsById(Long id) {
        return sysSmsSettingRepoitory.findById(id);
    }

    @Override
    public int updateSms(String url, String username, String password, String content) {
        return sysSmsSettingRepoitory.updateSmsById(url, username, password, content, (long) 1);
    }

    @Override
    public SysMailSetting getMailById() {
        return sysMailSettingRepoitory.findById((long) 1);
    }

}
