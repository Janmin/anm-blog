package cc.anmink.web;

import cc.anmink.baseServe.MyMailSend;
import cc.anmink.baseServe.MyResponse;
import cc.anmink.entity.SysMailSetting;
import cc.anmink.entity.SysSetting;
import cc.anmink.entity.SysUser;
import cc.anmink.service.SettingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
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
    public void sendMail() throws UnsupportedEncodingException, MessagingException {
        SysMailSetting sysMailSetting = settingService.getMailById();

        MyMailSend myMailSend = new MyMailSend();
//        sysMailSetting.getUsername(),sysMailSetting.getPassword(),sysMailSetting.getHost(), "zijian92@qq.com", "zijian92@163.com",sysMailSetting.getSubject(),sysMailSetting.getText()
        myMailSend.sendMimeMailMessage(sysMailSetting.getUsername(),sysMailSetting.getPassword(),sysMailSetting.getHost(),"465","zijian92@qq.com","zijian92@163.com",sysMailSetting.getSubject(),sysMailSetting.getText());
    }
}
