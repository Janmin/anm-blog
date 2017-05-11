package cc.anmink.web;

import cc.anmink.baseServe.MyRequest;
import cc.anmink.baseServe.MyResponse;
import cc.anmink.entity.SysSetting;
import cc.anmink.entity.SysSmsSetting;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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

    @RequestMapping(value = "/api/send-sms", method = RequestMethod.GET)
    @ResponseBody
    public MyResponse sendSms() {
//        String result = MyRequest.sendGet("http://112.124.17.46:7001/sms_token", "ddtkey=yueke&secretkey=2d4e42294fdd9f58399650e05298fd22&mobile=18602534705&content=您的验证码为100,30秒内有效");
        SysSmsSetting sysSmsSetting = settingService.getSmsById((long) 1);
        String url = sysSmsSetting.getUrl();
        String content = sysSmsSetting.getContent();
        content = content.replace("100", "500");
        System.out.println(content);
        return new MyResponse(200, "success", sysSmsSetting);
    }
}
