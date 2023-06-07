package com.wn.dbms.controller;

import com.wn.dbms.entity.Table;
import com.wn.dbms.entity.TableField;
import com.wn.dbms.service.TableDQLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/dql")
public class TableDQLController {
    @Autowired
    TableDQLService tableDQLService;

    @GetMapping("/selectTableList")
    public List<Table> selectTableList(){
        return tableDQLService.selectTableList();
    }

    @GetMapping("/selectTableFieldList")
    public List<TableField> selectTableFieldList(){
        return tableDQLService.selectTableFieldList();
    }
}
