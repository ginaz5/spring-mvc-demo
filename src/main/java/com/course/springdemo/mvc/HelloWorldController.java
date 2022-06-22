package com.course.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class HelloWorldController {

    // initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // process HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // read from data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("msg", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName,
            Model model) {

        // read the request parameter from the HTML form
        theName = theName.toUpperCase();
        String result = "Yo! This is version three " + theName;

        // add message to the model
        model.addAttribute("msg", result);

        return "helloworld";
    }

}
