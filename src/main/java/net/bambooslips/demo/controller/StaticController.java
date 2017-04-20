package net.bambooslips.demo.controller;

/**
 * Created by Eureka on 2016/5/16.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {

    @RequestMapping("/intro")
    public String intro() {
        return "intro";
    }

    @RequestMapping("/intro/info")
    public String info() {
        return "static/info";
    }

    @RequestMapping("/intro/regulation")
    public String regulation() {
        return "static/regulation";
    }

    @RequestMapping("/intro/org")
    public String org() {
        return "static/org";
    }

    @RequestMapping("/intro/rule")
    public String rule() {
        return "static/rule";
    }

}

