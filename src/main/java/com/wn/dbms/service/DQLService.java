package com.wn.dbms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wn.dbms.entity.User;
import com.wn.dbms.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DQLService{
    @Autowired
    UserMapper userMapper;

    /**
     * 根据id查询User，作为工具方法使用
     * @param id
     * @return
     */
    public User selectUserById(Integer id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",id);
        User queryResult = userMapper.selectOne(queryWrapper);
        if(queryResult != null){
            return queryResult;
        }else{
            return null;
        }

    }
}
