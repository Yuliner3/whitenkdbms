package com.wn.dbms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wn.dbms.entity.Database;
import com.wn.dbms.entity.Table;
import com.wn.dbms.entity.User;
import com.wn.dbms.mapper.DatabaseMapper;
import com.wn.dbms.mapper.TableMapper;
import com.wn.dbms.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DQLService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    DatabaseMapper databaseMapper;
    @Autowired
    TableMapper tableMapper;

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

    /**
     * 查询库中所有用户信息
     * @return
     */
    public List<User> selectUserList() {
        List<User> userList = userMapper.selectList(null);
        if(userList != null){
            return userList;
        }else{
            return null;
        }
    }
    /**
     * 查询所有数据库列表
     * @return
     */
    public List<Database> selectDBList() {
        List<Database> dbList = databaseMapper.selectList(null);
        if(dbList != null){
            return dbList;
        }else{
            return null;
        }
    }
    /**
     * 查询所有表列表
     * @return
     */
    public List<Table> selectTableList() {
        List<Table> tables = tableMapper.selectList(null);
        if(tables != null){
            return tables;
        }else{
            return null;
        }
    }
    /**
     * 查询所有查询列表
     * @return
     */

    /**
     * 查询所有函数列表
     * @return
     */

    /**
     * 查询所有权限列表
     * @return
     */

    /**
     * 查询所有视图列表
     * @return
     */

    /**
     * 查询所有表细节列表
     * @return
     */
}
