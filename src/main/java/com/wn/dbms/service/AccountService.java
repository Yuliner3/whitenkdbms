package com.wn.dbms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wn.dbms.entity.User;
import com.wn.dbms.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class AccountService {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询库中所有用户信息
     * @return
     */
    public List<User> selectUserList() {
        List<User> userList = userMapper.selectList(null);
        if(userList != null){
            log.warn("List====>{}",userList);
        }else{
            log.warn("====>{}","query null");
        }
        return userList;
    }
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
            log.warn("List====>{}",queryResult);
        }else{
            log.warn("====>{}","query null");
        }
        return queryResult;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public User accountLogin(String username, String password) {
        /*
        //test
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);*/

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_account", username).eq("u_password", password);

        User user = userMapper.selectOne(queryWrapper);
        if(user != null){
            log.warn("========>{}",user.toString());
        }else{
            log.warn("========>{}","账号密码错误！");
        }
        return user;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public Integer register(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_account",user.getUAccount());
        User queryUserResult = userMapper.selectOne(queryWrapper);
        int result = 0;
        if(queryUserResult == null){
            result = userMapper.insert(user);
            log.warn("=========> {}",user.toString());
            log.warn("账号注册成功");
        }else{
            log.warn("该账号已被注册");
        }
        log.info("=========> {}", result);
        return result;
    }

    /**
     * 根据用户ID修改密码
     * @param password
     * @param id
     * @return
     */
    public Integer updatePwdById(String password,Integer id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",id);
        User queryUserResult = userMapper.selectOne(queryWrapper);
        Integer updateResult = 0;
        if(queryUserResult != null){
            updateResult = userMapper.updatePwdById(password,id);
            log.warn("=========> {}","更新成功！");
            queryWrapper.eq("u_id",id);
            queryUserResult = userMapper.selectOne(queryWrapper);
            log.warn("更新后=========> {}",queryUserResult.toString());
        }else{
            log.warn("=========> {}","该用户不存在！");
        }
        log.info("=========> {}", updateResult);
        return updateResult;

    }

    /**
     * 依据用户ID删除用户
     * @param integer
     * @return
     */
    public Integer deleteUserById(Integer integer) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",integer);
        User queryUserResult = userMapper.selectOne(queryWrapper);
        Integer deleteResult = 0;
        if(queryUserResult != null){
            deleteResult = userMapper.delete(queryWrapper);
            log.warn("=========> {}","删除成功！");
        }else{
            log.warn("=========> {}","该用户不存在！");
        }
        return deleteResult;
    }
}
