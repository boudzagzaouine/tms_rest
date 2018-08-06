package com.bagile.tms.controllers;

import com.bagile.tms.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/accounts/")
public class BadgeTypeController {

    @Autowired
    private BadgeTypeService badgeTypeService;

}