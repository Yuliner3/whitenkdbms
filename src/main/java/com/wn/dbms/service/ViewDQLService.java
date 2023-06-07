package com.wn.dbms.service;

import com.wn.dbms.entity.View;
import com.wn.dbms.mapper.ViewMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ViewDQLService {
    @Autowired
    ViewMapper viewMapper;

    /**
     * 查询所有视图列表
     * @return
     */
    public List<View> selectViewList() {
        List<View> views = viewMapper.selectList(null);
        if(views != null){
            log.warn("List====>{}",views);
        }else{
            log.warn("====>{}","query null");
        }
        return views;
    }
}
