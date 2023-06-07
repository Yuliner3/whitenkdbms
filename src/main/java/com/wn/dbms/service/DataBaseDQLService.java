package com.wn.dbms.service;

import com.wn.dbms.entity.Database;
import com.wn.dbms.mapper.DatabaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DataBaseDQLService {
    @Autowired
    DatabaseMapper databaseMapper;

    /**
     * 查询所有数据库列表
     * @return
     */
    public List<Database> selectDBList() {
        List<Database> dbList = databaseMapper.selectList(null);
        if(dbList != null){
            log.warn("List====>{}",dbList);
        }else{
            log.warn("====>{}","query null");
        }
        return dbList;
    }
}
