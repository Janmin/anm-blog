package cc.anmink.web;

import cc.anmink.entity.SysSetting;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Jamin on 2017/3/22.
 */
@Controller
public class SystemSetController {

    @Autowired
    SettingService settingService;


    @RequestMapping("/admin/system-set")
    public String systemSet(Map map) {
        SysSetting sysSetting = settingService.getById();
        map.put("info", sysSetting);
        return "admin/system-set";
    }
}
