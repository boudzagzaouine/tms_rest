package com.bagile.tms.controllers;

import com.bagile.gmo.dto.User;
import com.bagile.tms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

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
