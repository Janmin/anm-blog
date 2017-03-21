package cc.anmink.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiezijian on 2017/3/21.
 */
@Controller
public class UserController {
    @RequestMapping("/admin/user")
    public String user() {
        return "admin/user";
    }
}
