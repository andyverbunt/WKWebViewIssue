package com.company.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@org.springframework.stereotype.Controller
@EnableAutoConfiguration
@CrossOrigin(origins = "null", maxAge = 3600)
public class FooBarController {


    @RequestMapping("/login")
    @ResponseBody
    String login(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("foo", "bar");
        return "Cookie should be set (check response headers)";
    }


    @RequestMapping("/foo")
    @ResponseBody
    String showInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute("foo");
        return value;
    }
}
