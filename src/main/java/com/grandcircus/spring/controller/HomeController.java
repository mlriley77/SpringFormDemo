package com.grandcircus.spring.controller;

import com.grandcircus.spring.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by MichaelRiley on 5/8/17.
 */


@Controller
public class HomeController {

    @RequestMapping ("/")//handler mapping
    public ModelAndView helloWorld(){//model and view method - has to return a model and view
        return new ModelAndView("welcome", "hello", "hello world");//pass through only "hello world"
    }

    //@requestmapping from jsp containing html and link

    @RequestMapping (value="/student", method= RequestMethod.GET)
    public ModelAndView student(){

        return new ModelAndView("student", "command", new Student());
    }
    @RequestMapping (value="/addStudent", method=RequestMethod.POST)
    public String addStudent(Student student, Model model){//pass through multiple
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("Id", student.getId());


        return "result";//string meaning result.jsp page
    }
}



