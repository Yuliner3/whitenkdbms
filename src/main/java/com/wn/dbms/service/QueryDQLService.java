package com.wn.dbms.service;

import com.wn.dbms.entity.Query;
import com.wn.dbms.mapper.QueryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QueryDQLService {
    @Autowired
    QueryMapper queryMapper;

    /**
     * 查询所有查询列表
     * @return
     */
    public List<Query> selectQueryList() {
        List<Query> queries = queryMapper.selectList(null);
        if(queries != null){
            log.warn("List====>{}",queries);
        }else{
            log.warn("====>{}","query null");
        }
        return queries;
    }
}
