package cn.itcast.springmvc.controller;

import cn.itcast.pojo.User;
import cn.itcast.pojo.UserVO;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("hello")
public class Hello2Controller{

    @RequestMapping("show1")
    public ModelAndView test1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","springMVC的第一个程序");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @RequestMapping("sss?/show2")
    public ModelAndView test2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","springMVC的第二个程序");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @RequestMapping("aa*/show3")
    public ModelAndView test3(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","springMVC的第三个程序");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @RequestMapping("/**/show3")
    public ModelAndView test4(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","springMVC的第四个程序");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping("/show5/{username}/{id}")
    public ModelAndView test5(@PathVariable("username")String username,@PathVariable("id")Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","测试占位符  姓名："+username+" id:"+id);
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value ="/show6",method = {RequestMethod.POST,RequestMethod.PUT})
    public ModelAndView test6() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","this is test limited method show6");
        mv.setViewName("hello");
        return mv;
    }
    @RequestMapping(value ="/show7",params = "id")
    public ModelAndView test7() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","this is test about limite request param");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value ="/show9",params = "!id")
    public ModelAndView test9() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","this is test about limite request param of !id");
        mv.setViewName("hello");
        return mv;
    }
    @RequestMapping(value ="/show10",params = "id!=1")
    public ModelAndView test10() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","this is test about limite request param of id!=1");
        mv.setViewName("hello");
        return mv;
    }
    @RequestMapping(value ="/show11",params = "id=1")
    public ModelAndView test11() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","this is test about limite request param of id=1");
        mv.setViewName("hello");
        return mv;
    }

    @GetMapping("/show12")
    public ModelAndView test12() {
        ModelAndView hello = new ModelAndView("hello");
        hello.addObject("msg","haha");
        return hello;
    }

    @PutMapping("/show13")
    public ModelAndView test13() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg", "this is putmapping test");
        return mv;
    }

//    @DeleteMapping("/show14")
//    public ModelAndView test14() {
//        ModelAndView mv = new ModelAndView("hello");
//        mv.addObject("msg", "this is deletemapping test");
//        return mv;
//    }
@RequestMapping("/show14")
public String test14(Model model, ModelMap map) {
    //ModelAndView mv = new ModelAndView("hello");
    model.addAttribute("msg", "this is deletemapping test");
    map.addAttribute("msg", "this is deletemapping test2");
    return "hello";
}

    @RequestMapping("show15")
    public ModelAndView test15(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView("hello");
        StringBuffer sb = new StringBuffer();
        sb.append("request"+request+"<br/>");
        sb.append("response:"+response+"<br/>");
        sb.append("session:"+session);
        mv.addObject("msg","springmvc接受参数与数据绑定：内置参数"+sb.toString());
        return mv;
    }

    @RequestMapping("/show15/{name}")
    public ModelAndView test16(@PathVariable("name")String name) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("msg","springmvc传递有参："+name);
        return mv;
    }
    @RequestMapping("show17")
    public String test17(Model model,@RequestParam("name")String name){
        model.addAttribute("msg","接受普通参数："+name);
        return "hello";
    }
    @RequestMapping("show18")
    public String test18(Model model,@RequestParam(value="name",required =false )String name){
        model.addAttribute("msg","接受普通参数："+name);
        return "hello";
    }
    @RequestMapping("show19")
    public String test19(Model model,@RequestParam(value="name",required = true,defaultValue = "张国荣")String name){
        model.addAttribute("msg","接受普通参数："+name);
        return "hello";
    }

@RequestMapping("show20")
    public String test20(Model model,HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if(cookies!=null){
        for (Cookie cookie : cookies) {
            if("JSESSIONID".equals(cookie.getName())){
                model.addAttribute("msg","获取cookie参数：JESSIONID" +cookie.getValue());
            }
        }
    }
    return "hello";
}

    @RequestMapping("show21")
    public String test21(@CookieValue("JSESSIONID")String cookieValue,Model model) {
        System.out.println(cookieValue);
        model.addAttribute("msg","JSESSIONID:"+cookieValue);
        return "hello";
    }

    @RequestMapping("show22")
    public void test22(@RequestParam("name")String name,
                         @RequestParam("age")int age,
                         @RequestParam("isMarry")Boolean isMarry,
                         @RequestParam("income")int income,
                         @RequestParam("interests")String[] interests) {
        StringBuffer sb = new StringBuffer();
        sb.append("name:"+name+" ");
        sb.append("age:"+age+" ");
        sb.append("isMarry:"+isMarry+" ");
        sb.append("income:"+income);
        sb.append("interests:"+"[");
        for (String s : interests) {
            sb.append(s+",");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @RequestMapping("show23")
    public String test23(User user,Model model) {
        model.addAttribute("msg",user.toString()+"<br/>");
        return "hello";
    }
    @RequestMapping("show24")
    public String test24(UserVO userV0, Model model) {
        model.addAttribute("msg",userV0.getUsers().toString()+"<br/>");
        return "hello";
    }

    @RequestMapping("show25")
    public String test25(Model model){
        ArrayList<User> users = new ArrayList<>();
        for (int i=0;i<10;i++){
            User user = new User();
            user.setAge(10+i);
            user.setId(1+i);
            user.setName("张三");
            user.setUserName("zhamgsan");
            users.add(user);
        }
        model.addAttribute("users",users);
        return "user";
    }
    @RequestMapping("show26")
    @ResponseBody
    public List<User> test26(){
        ArrayList<User> users = new ArrayList<>();
        for (int i=0;i<10;i++){
            User user = new User();
            user.setAge(10+i);
            user.setId(1+i);
            user.setName("张三");
            user.setUserName("zhamgsan");
            users.add(user);
        }
        return users;
    }

    @RequestMapping("show27")
    public String test27(@RequestBody User user,Model model) {
        model.addAttribute("msg",user.toString());
        return "hello";
    }

    @RequestMapping("show30")
    public String test30(Model model, @RequestParam("file")MultipartFile file) throws IOException {
        if(file!=null){
            file.transferTo(new File("c:\\tmp\\"+file.getOriginalFilename()));
            System.out.println(file.getOriginalFilename());
        }
        return "redirect:/success.html";
    }
}
