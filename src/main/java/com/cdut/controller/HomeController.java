package com.cdut.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/404")
    public String notfind(){
        return "404";
    }
}
