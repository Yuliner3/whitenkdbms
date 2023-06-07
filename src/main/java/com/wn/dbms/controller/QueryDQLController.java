package com.wn.dbms.controller;

import com.wn.dbms.entity.Query;
import com.wn.dbms.service.QueryDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dql")
public class QueryDQLController {
    @Autowired
    QueryDQLService queryDQLService;

    @GetMapping("/selectQueryList")
    public List<Query> selectQueryList(){
        return queryDQLService.selectQueryList();
    }

}
