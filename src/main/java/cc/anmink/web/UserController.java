package cc.anmink.web;

import cc.anmink.entity.SysUser;
import cc.anmink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by xiezijian on 2017/3/21.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/admin/user")
    public String user(Map map) {
        List<SysUser> sysUsers = userService.getAll();
        map.put("lists", sysUsers);
        return "admin/user";
    }

    @RequestMapping("/api/user/add")
    @ResponseBody
    public SysUser userAdd(String username, String password, String avatar, String name, String address, Long phone, Long created, String roles_name) {
        SysUser sysUser = userService.create(username, password, avatar, name, address, phone, created, roles_name);
        return sysUser;
    }

}
