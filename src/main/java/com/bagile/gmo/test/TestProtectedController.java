package com.bagile.gmo.test;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestProtectedController {

    @GetMapping("/secure")
    @PreAuthorize("hasAuthority('USER_READ')")
    public String secure() {
        return "secure-data";
    }
}

