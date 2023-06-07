package com.wn.dbms.controller;

import com.wn.dbms.entity.Function;
import com.wn.dbms.service.FunctionDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dql")
public class FunctionDQLController {
    @Autowired
    FunctionDQLService functionDQLService;

    @GetMapping("/selectFunList")
    public List<Function> selectFunctionList(){
        return functionDQLService.selectFunList();
    }
}
