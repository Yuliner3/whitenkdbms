package com.wn.dbms.controller;

import com.wn.dbms.entity.User;

import com.wn.dbms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dql")
public class DQLController {
    @Autowired
    AccountService accountService;

    @GetMapping("/selectUserList")
    public List<User> selectUserList(){
        return accountService.selectUserList();
    }

}
