package cc.anmink.web;

import cc.anmink.baseServe.MyMailSend;
import cc.anmink.baseServe.MyResponse;
import cc.anmink.entity.SysSetting;
import cc.anmink.entity.SysUser;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Properties;

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

    @RequestMapping("/admin/send-mail")
    @ResponseBody
    public void sendMail() {
        MyMailSend myMailSend = new MyMailSend();
        myMailSend.sendSimpleMailMessage();
    }
}
