package halo.app.controller.api.admin;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {



    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(){
        return "test";
    }
}
