package com.hundsun.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,
                               Integer age){
        System.out.println("===========StudentController中的方法开始执行=========");
        //处理some.do请求,此处模拟service调用完成
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        mv.setViewName("show");
        return mv;
    }

}
