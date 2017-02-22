package com.ecps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-21 下午 05:22
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
