package com.wn.dbms.service;

import com.wn.dbms.entity.Right;
import com.wn.dbms.mapper.RightMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RightDQLService {
    @Autowired
    RightMapper rightMapper;

    /**
     * 查询所有权限列表
     * @return
     */
    public List<Right> selectRightList() {
        List<Right> rights = rightMapper.selectList(null);
        if(rights != null){
            log.warn("List====>{}",rights);
        }else{
            log.warn("====>{}","query null");
        }
        return rights;
    }
}
