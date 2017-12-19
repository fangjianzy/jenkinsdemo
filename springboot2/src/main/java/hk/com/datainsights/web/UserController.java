package hk.com.datainsights.web;

import hk.com.datainsights.entry.UserEntry;
import hk.com.datainsights.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mybatisController")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  UserEntry getAccountById(@PathVariable("id") long pkid){
        return userService.findById(pkid);
    }
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
    public  String postAccount(@RequestParam(value = "name")String name,@RequestParam(value = "age" )int age){
		UserEntry user=new UserEntry();
		user.setAge(age);
		user.setName(name);
        long t= userService.addUser(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }
    }
}
