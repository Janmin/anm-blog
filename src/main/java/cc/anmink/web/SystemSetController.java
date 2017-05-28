package cc.anmink.web;

import cc.anmink.baseServe.MyRequest;
import cc.anmink.baseServe.MyMailSend;
import cc.anmink.baseServe.MyResponse;
import cc.anmink.entity.SysMailSetting;
import cc.anmink.entity.SysSetting;
import cc.anmink.entity.SysSmsSetting;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
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
        // 获取系统设置
        SysSetting sysSetting = settingService.getById();
        // 获取短信设置
        SysSmsSetting sysSmsSetting = settingService.getSmsById((long) 1);
        // 获取邮件设置
        SysMailSetting sysMailSetting = settingService.getMailById();

        map.put("sys_info", sysSetting);
        map.put("sms_info", sysSmsSetting);
        map.put("mail_info", sysMailSetting);
        return "admin/system-set";
    }


    @RequestMapping(value = "/api/sms-send", method = RequestMethod.GET)
    @ResponseBody
    public MyResponse sendSms() {
        SysSmsSetting sysSmsSetting = settingService.getSmsById((long) 1);
        String url = sysSmsSetting.getUrl();
        String content = sysSmsSetting.getContent();
        content = content.replace("{number}", "500");

        String params = "ddtkey=" + sysSmsSetting.getUsername() + "&secretkey=" + sysSmsSetting.getPassword() + "&mobile=18602534705&content=" + content;
        String result = MyRequest.sendGet(url, params);
        if (result.substring(0, 4) == "/nok") {
            return new MyResponse(200, "success", null);
        } else {
            return new MyResponse(400, "fail", null);
        }
    }

    @RequestMapping(value = "/api/admin/sms-setting-update", method = RequestMethod.POST)
    @ResponseBody
    public MyResponse updateSmsSetting(String url, String username, String password, String content) {
        try {
            int i = settingService.updateSms(url, username, password, content);
            System.out.println(i);
            return new MyResponse(200, "success", null);
        } catch (Exception e) {
            return new MyResponse(400, "fail", null);
        }

    }


    @RequestMapping("/api/mail-send")
    @ResponseBody
    public MyResponse sendMail() throws UnsupportedEncodingException, MessagingException {
        SysMailSetting sysMailSetting = settingService.getMailById();

        MyMailSend myMailSend = new MyMailSend();

        try {
            myMailSend.sendMimeMailMessage(sysMailSetting.getUsername(), sysMailSetting.getPassword(), sysMailSetting.getHost(), "465", "zijian92@qq.com", "zijian92@163.com", sysMailSetting.getSubject(), sysMailSetting.getText());
            return new MyResponse(200, "success", null);
        } catch (Exception e) {
            return new MyResponse(400, "fail", null);
        }
    }
}
