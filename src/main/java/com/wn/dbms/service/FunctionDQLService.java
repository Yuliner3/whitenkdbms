package com.wn.dbms.service;

import com.wn.dbms.entity.Function;
import com.wn.dbms.mapper.FunctionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FunctionDQLService {
    @Autowired
    FunctionMapper functionMapper;

    /**
     * 查询所有函数列表
     * @return
     */
    public List<Function> selectFunList() {
        List<Function> functions = functionMapper.selectList(null);
        if(functions != null){
            log.warn("List====>{}",functions);
        }else{
            log.warn("====>{}","query null");
        }
        return functions;
    }
}
