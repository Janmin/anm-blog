package cc.anmink.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xiezijian on 2017/3/10.
 */
@Controller
public class AdminController {
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin() {
        return "admin/dashboard";
    }
}
