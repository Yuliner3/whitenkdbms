package com.wn.dbms.service;

import com.wn.dbms.entity.TableField;
import com.wn.dbms.mapper.TableFieldMapper;
import com.wn.dbms.mapper.TableMapper;
import com.wn.dbms.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class TableDMLService {
    @Autowired
    TableFieldMapper tableFieldMapper;
    @Autowired
    TableMapper tableMapper;

    /**
     * 创建拥有一个字段信息的初始表
     * @param tableName
     * @param tableField
     * @return
     */
    public String createTable(String tableName, TableField tableField) {
        String ifNull = "";
        String key = "";
        if(tableField.getIfNull() == 0){
            ifNull = "not null";
        }
        if(tableMapper.ifExistTable(tableName) == 0){
            if(tableField.getIfKey() == 1){
                key = tableField.getFieldName();
                tableFieldMapper.createTableByKey(tableName,
                        tableField.getFieldName(),
                        tableField.getFieldType(),
                        tableField.getFieldLength(),
                        key,
                        ifNull,
                        tableField.getFieldDesc());
            }else {
                tableFieldMapper.createTableByNoKey(tableName,
                        tableField.getFieldName(),
                        tableField.getFieldType(),
                        tableField.getFieldLength(),
                        ifNull,
                        tableField.getFieldDesc());
            }
            return "创建成功";
        }else{
            log.warn("====>{}","该表已存在！");
            return "创建失败";
        }
    }

    /**
     * 给刚创建的表添加字段
     * @param tableName
     * @param all
     * @return
     */
    public String addTableField(String tableName, HashMap<String, List> all) {

        String result = "";
        String if_null = "";
        String if_key = "";
        List<String> name = all.get("fieldName");
        List<String> type = all.get("fieldType");
        List<String> length = all.get("fieldLength");
        List<Integer> ifNull = all.get("ifNull");
        List<Integer> ifKey = all.get("ifKey");
        List<String> desc = all.get("fieldDesc");

        List<Integer> index = Utils.findListRepeat(ifKey);      //找到ifKey里的重复元素的下标

        for(int i = 1; i < all.get("fieldName").size(); i++){
            if(index.size() == 1 || index.size() == 0){ //判断主键是否重复
                if(ifNull.get(i) == 0){
                    if_null = "not null";
                }else{
                    if_null = "";
                }
                if(ifKey.get(i) == 1){
                    if_key = name.get(i);
                    tableFieldMapper.addTableFieldByKey(tableName,
                            name.get(i),
                            type.get(i),
                            length.get(i),
                            if_key,
                            if_null,
                            desc.get(i));
                }else {
                    tableFieldMapper.addTableFieldByNoKey(tableName,
                            name.get(i),
                            type.get(i),
                            length.get(i),
                            if_null,
                            desc.get(i));
                }
                result =  "添加成功";
            }else{
                result = "主键只能有一个";
            }
        }
        return result;
    }

    public int tableIfExists(String tableName){
        return tableMapper.ifExistTable(tableName);
    }

    /**
     * 根据表名删表
     * @param tableName
     * @return
     */
    public boolean delTable(String tableName) {
        if(tableMapper.ifExistTable(tableName) == 0){
            log.warn("====>{}","表不存在");
            return false;
        }else{
            tableMapper.dropTable(tableName);
            return true;
        }
    }
}
