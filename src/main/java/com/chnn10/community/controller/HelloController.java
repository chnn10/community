package com.chnn10.community.controller;

import com.chnn10.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.instrument.UnmodifiableClassException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("home")
public class HelloController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return alphaService.find();
    }

    @RequestMapping("http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //请求的数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+": "+value);
        }
        System.out.println(request.getParameter("code"));
        //返回数据
        response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("<h1>hello world</h1>");
    }

    //Get请求
    //请求待参数的例如：students?current&limit=20
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name="current",required = false,defaultValue = "1") int current,
            @RequestParam(name="limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "hello students";
    }

    //根据学生的ID查询一个学生
    //students/123
    @RequestMapping(path = "/students/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public String getStudentById(@PathVariable("id") int id){
        System.out.println(id);
        return " a student";
    }

    //POST请求，一般带有表单的网页，就用这个请求。
    //申明访问路径，强调请求方式是post
    //响应，用@RequestBody，我们就返回一个字符串
    //这个方法怎么获取post的请求参数呢？
    //直接申明参数，与html表单申明的参数一致，就会传进来了，我们把传进来的参数打印在控制台。
    @RequestMapping(path = "/students/info" ,method = RequestMethod.POST)
    @ResponseBody
    public String studentInfo(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张张张");
        modelAndView.addObject("age","12");
        modelAndView.setViewName("demo/view");
        return  modelAndView;
    }

    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","陈一");
        map.put("age","12");
        map.put("salary","10000");
        return map;
    }




}
