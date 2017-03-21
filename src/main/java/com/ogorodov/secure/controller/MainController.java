package com.ogorodov.secure.controller;

import com.ogorodov.common.exceptions.UserDaoException;
import com.ogorodov.secure.entity.User;
import com.ogorodov.secure.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    private static Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String startUser(Principal principal, Model model) {
        logger.trace("User ty " + principal.getName());
        User user = userService.getUser(principal.getName());
        model.addAttribute(user);
        logger.trace("testUser " + user.getName());
        return "user";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers(Principal principal,ModelAndView model) {
        logger.trace("UsershowUsers nety " + principal);
        logger.trace("neteshowUsersstUser " + principal.getName());
        return model;

    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String showUser(Principal principal, Model model) {
        logger.trace("User nety " + principal);
        logger.trace("netestUser " + principal.getName());

        return "user";
    }

}
