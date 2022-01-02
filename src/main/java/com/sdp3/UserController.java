
package com.sdp3;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserController {
        @Autowired
        UserRepo user;
        @RequestMapping(value="/")
        public String index()
        {
          return "index";
        }   
    @RequestMapping(value="/login")
    public String display()
    {
      return "login";
    }
    @RequestMapping(value="/adduser")
    public String adduser(User u)
    {
      System.out.println(u.username);
      user.save(u);
      return "login";
    }
    @RequestMapping(value="/logincheck")
    public String logincheck(User u)
    {
      List<User> u2=user.findByUsername(u.username);
      for(User i : u2)
      {
        System.out.println(i.password);
        System.out.println(u.password);
        if(i.password.equals(u.password))
        {
          return "index";
        }
      }
      return "login";
    }
}