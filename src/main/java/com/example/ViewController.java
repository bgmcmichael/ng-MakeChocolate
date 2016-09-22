package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fenji on 9/22/2016.
 */

@Controller
public class ViewController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String login(HttpSession session, Model model) throws Exception{
        return "home";
    }
}
