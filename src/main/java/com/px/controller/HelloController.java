package com.px.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String Hello(){
        return "redirect:index.html";
    }


    @RequestMapping("/lev1/{id}")
    public String lev1(@PathVariable("id") String id){
        return "admin/lev1/"+id;
    }
    @RequestMapping("/lev2/{id}")
    public String lev2(@PathVariable("id") String id){
        return "admin/lev2/"+id;
    }
    @RequestMapping("/lev3/{id}")
    public String lev3(@PathVariable("id") String id){
        return "admin/lev3/"+id;
    }
}
