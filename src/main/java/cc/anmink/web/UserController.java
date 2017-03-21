package cc.anmink.web;

import cc.anmink.entity.SysUser;
import cc.anmink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
