package cc.anmink.web;

import cc.anmink.entity.SysSetting;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by xiezijian on 2017/3/10.
 */
@Controller
public class AdminController {

    private SysSetting sysSetting;

    @Autowired
    SettingService settingService;

    @Autowired
    public void getSetting() {
        this.sysSetting = settingService.getById();
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Map map) {
        map.put("sys_info", sysSetting);
        return "admin/dashboard";
    }
}
