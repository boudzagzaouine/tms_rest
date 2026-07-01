package com.bagile.gmo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The legacy {@code GET /authentification} endpoint (which took the password in the query string
 * and returned the full user) has been retired — authentication now goes through
 * {@link AuthenticationController} (POST /api/auth/login).
 */
@Controller
public class LoginController {

    @RequestMapping("/defaultSuccessUrl")
    @ResponseBody
    public String defaultSuccessUrl() {
        return "defaultSuccessUrl";
    }
}
