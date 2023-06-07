package com.wn.dbms.service;

import com.wn.dbms.entity.Table;
import com.wn.dbms.entity.TableField;
import com.wn.dbms.mapper.TableFieldMapper;
import com.wn.dbms.mapper.TableMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TableDQLService {
    @Autowired
    TableMapper tableMapper;
    @Autowired
    TableFieldMapper tableFieldMapper;

    /**
     * 查询所有表列表
     * @return
     */
    public List<Table> selectTableList() {
        List<Table> tables = tableMapper.selectList(null);
        if(tables != null){
            log.warn("List====>{}",tables);
        }else{
            log.warn("====>{}","query null");
        }
        return tables;
    }
    /**
     * 查询所有表字段列表
     * @return
     */
    public List<TableField> selectTableFieldList() {
        List<TableField> tableFields = tableFieldMapper.selectList(null);
        if(tableFields != null){
            log.warn("List====>{}",tableFields);
        }else{
            log.warn("====>{}","query null");
        }
        return tableFields;
    }
}
