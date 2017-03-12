package cc.anmink.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jamin on 2017/3/10.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "home/landing";
    }
}
