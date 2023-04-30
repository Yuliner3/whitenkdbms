package com.wn.dbms.controller;

import com.wn.dbms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        return accountService.accountLogin(username, password);
    }
}
