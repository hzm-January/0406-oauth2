package houzm.accumulation.oauth2.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/3 16:59
 * Modified By:
 * Description： 通过认证后可访问的资源
 */

@RestController
@RequestMapping("/api/")
public class AuthenticationController {


    @GetMapping(value = "show")
    public String show() {
        System.out.println(" i come in");
        return "i can show";
    }
}

