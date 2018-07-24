package com.bagile.tms.controllers;

import com.sinno.ems.dto.User;
import com.sinno.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by adadi on 12/23/2015.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/defaultSuccessUrl")
    @ResponseBody
    public String defaultSuccessUrl() {

        return "defaultSuccessUrl";
    }

    @RequestMapping("/authentification")
    @ResponseBody
    public User login(@RequestParam String email, @RequestParam String password) {
        return userService.findByEmailAndPassowrd(email, password);
    }
}
