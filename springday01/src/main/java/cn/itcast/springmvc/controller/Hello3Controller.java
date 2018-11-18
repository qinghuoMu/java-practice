package cn.itcast.springmvc.controller;

import cn.itcast.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hello")
public class Hello3Controller {
    @RequestMapping(value = "show28")
    public String test28(Model model, HttpServletRequest request) {
        model.addAttribute("msg", "这是springmvc特有的内置对象");
        request.setAttribute("msg", "这是servlet内置对象");
        return "hello";
    }

    @RequestMapping("show29")
    public List<User> test29(){
        List<User> userList = new ArrayList<>();
        for(int i=0; i<20; i++){
            User user = new User();
            user.setAge(17 + i);
            user.setName("高晓松");
            user.setUserName("xiaosong");
            user.setId(i + 1);
            userList.add(user);
        }
        return userList;
    }
public void test(){

}

}
