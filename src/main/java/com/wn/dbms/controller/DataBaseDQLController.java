package com.wn.dbms.controller;

import com.wn.dbms.entity.Database;
import com.wn.dbms.service.DataBaseDQLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dql")
public class DataBaseDQLController {
    @Autowired
    DataBaseDQLService dataBaseDQLService;

    @GetMapping("/selectDBList")
    public List<Database> selectDBList(){
        return dataBaseDQLService.selectDBList();
    }
}
