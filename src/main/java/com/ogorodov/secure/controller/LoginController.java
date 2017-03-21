package com.ogorodov.secure.controller;


import com.ogorodov.common.exceptions.UserDaoException;
import com.ogorodov.common.exceptions.UserJdbcTemlateException;
import com.ogorodov.secure.entity.User;
import com.ogorodov.secure.service.LevelService;
import com.ogorodov.secure.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LevelService levelService;

    private static Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public String authorization(Model model, @RequestParam("j_username") String login, @RequestParam("j_password") String password){

        logger.trace("String j_username" + login);
        User user = null;
        try {
            user = userService.getUserByLoginAndPassword(login, encodePassword(password));
        } catch (UserDaoException e) {
            e.printStackTrace();
        }
        logger.error(user);
            logger.trace("auth");
            model.addAttribute("user", user);
        return "/user";

    }*/

    private String encodePassword(String password) {
        return new ShaPasswordEncoder(1).encodePassword(password, null);
    }

}
