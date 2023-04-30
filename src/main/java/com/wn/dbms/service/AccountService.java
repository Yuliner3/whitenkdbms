package com.wn.dbms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wn.dbms.entity.User;
import com.wn.dbms.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountService {

    @Autowired
    UserMapper userMapper;

    public Object accountLogin(String username,String password){
        /*
        //test
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);*/

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_account",username).eq("u_password",password);

        User user = userMapper.selectOne(queryWrapper);
        log.warn("====> {}",user.getUEmail());



        return user;
    }
}
