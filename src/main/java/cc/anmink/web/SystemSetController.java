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
        SysSetting sysSetting = settingService.getById();
        map.put("info", sysSetting);
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
        System.out.println(params);
        String result = MyRequest.sendGet(url, params);
        System.out.println(result);
        if (result.substring(0, 4) == "/nok") {
            return new MyResponse(200, "success", null);
        } else {
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

    @RequestMapping("/api/test")
    @ResponseBody
    public MyResponse test(){
        String result = "/nok,201705141930050311";
        String res = result.substring(0, 4);
        System.out.println(res);
        if (result.substring(0, 4) == "/nok") {
            return new MyResponse(200, "success", null);
        } else {
            return new MyResponse(400, "fail", null);
        }
    }
}
