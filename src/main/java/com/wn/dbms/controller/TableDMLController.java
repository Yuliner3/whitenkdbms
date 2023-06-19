package com.wn.dbms.controller;

import com.wn.dbms.entity.TableField;
import com.wn.dbms.service.TableDMLService;
import com.wn.dbms.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dml")
public class TableDMLController {
    @Autowired
    TableDMLService tableDMLService;

    @GetMapping("/createTable")
    public String createTable(@RequestParam(value = "tableName") String tableName,
                               @RequestParam(value = "fieldName[]") List<String> fieldName,
                               @RequestParam(value = "fieldType[]") List<String> fieldType,
                               @RequestParam(value = "fieldLength[]") List<String> fieldLength,
                               @RequestParam(value = "ifNull[]",required = false) List<String> if_null,
                               @RequestParam(value = "ifKey[]",required = false) List<String> if_key,
                               @RequestParam(value = "fieldDesc[]",required = false) List<String> fieldDesc){

        TableField tableField;
        String result = "";
        //将ifNull && Key 转换为 Integer
        List<Integer> ifNull = new ArrayList<>();
        for (String s : if_null) {
            ifNull.add(s.equals("true") ? 1 : 0);
        }
        List<Integer> ifKey = new ArrayList<>();
        for (String s : if_key) {
            ifKey.add(s.equals("true") ? 1 : 0);
        }

        //先创建具有一行字段的表，再添加剩下存在的行
        if(tableDMLService.tableIfExists(tableName) == 0){
            tableField = new TableField(fieldName.get(0),
                    fieldType.get(0),
                    fieldLength.get(0),
                    ifNull.get(0),
                    ifKey.get(0),
                    fieldDesc.get(0));
            tableDMLService.createTable(tableName,tableField);
            result = "创建成功";
        }
        if(fieldName.size() > 1){
            HashMap<String, List> map = new HashMap<>();
            map.put("fieldName",fieldName);
            map.put("fieldType",fieldType);
            map.put("fieldLength",fieldLength);
            map.put("ifNull",ifNull);
            map.put("ifKey",ifKey);
            map.put("fieldDesc",fieldDesc);
            log.warn("map====>{}",map);
            result = tableDMLService.addTableField(tableName,map);
        }
        return result;
    }

    @GetMapping("/deleteTable")
    public boolean delTable(@RequestParam("tableName") String tableName){
        return tableDMLService.delTable(tableName);
    }
}
