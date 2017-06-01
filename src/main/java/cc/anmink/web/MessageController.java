package cc.anmink.web;

import cc.anmink.entity.SysMessage;
import cc.anmink.entity.SysSetting;
import cc.anmink.service.MessageService;
import cc.anmink.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by xiezijian on 2017/5/30.
 */
@Controller
public class MessageController {
    private SysSetting sysSetting;

    @Autowired
    SettingService settingService;

    @Autowired
    MessageService messageService;

    @Autowired
    public void getSetting() {
        this.sysSetting = settingService.getById();
    }

    @RequestMapping(value = "/admin/message")
    public String messageList(Map map) {
        List<SysMessage> sysMessages = messageService.getAll();
        map.put("lists", sysMessages);
        map.put("sys_info", sysSetting);
        return "admin/message";
    }

    @RequestMapping(value = "/admin/message/test")
    @ResponseBody
    public List<SysMessage> getAll() {
        List<SysMessage> sysMessages = messageService.getAll();
        return sysMessages;
    }
}
