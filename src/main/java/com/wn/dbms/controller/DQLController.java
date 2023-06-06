package com.wn.dbms.controller;

import com.wn.dbms.entity.Database;
import com.wn.dbms.entity.Table;
import com.wn.dbms.entity.User;
import com.wn.dbms.service.DQLService;
import javafx.scene.control.Tab;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dql")
public class DQLController {
    @Autowired
    DQLService dqlService;

    @GetMapping("/selectUserList")
    public List<User> selectUserList(){
        return dqlService.selectUserList();
    }


    @GetMapping("/selectDBList")
    public  List<Database> selectDBList(){
        return dqlService.selectDBList();
    }

    @GetMapping("/selectTableList")
    public List<Table> selectTableList(){
        return dqlService.selectTableList();
    }
}
