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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/dql")
public class DQLController {
    @Autowired
    DQLService dqlService;

    @GetMapping("/selectUserList")
    public String selectUserList(HttpServletRequest httpRequest){
        HttpSession session = httpRequest.getSession();
        List<User> userList ;
        userList = dqlService.selectUserList();
        if(userList != null){
            session.setAttribute("userList",userList);
        }else{
            session.setAttribute("userList","查询用户列表为空");
        }
        return "iteratorResult";
    }


    @GetMapping("/selectDBList")
    public String selectDBList(HttpServletRequest httpRequest){
        HttpSession session = httpRequest.getSession();
        List<Database> dbList ;
        dbList = dqlService.selectDBList();
        if(dbList != null){
            session.setAttribute("dbList",dbList);
        }else{
            session.setAttribute("dbList","查询数据库列表为空");
        }
        return "iteratorResult";
    }

    @GetMapping("/selectTableList")
    public String selectTableList(HttpServletRequest httpRequest){
        HttpSession session = httpRequest.getSession();
        List<Table> tables ;
        tables = dqlService.selectTableList();
        if(tables != null){
            session.setAttribute("tableList",tables);
        }else{
            session.setAttribute("tableList","查询数据库列表为空");
        }
        return "iteratorResult";
    }
}
