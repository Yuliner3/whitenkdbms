package com.wn.dbms;

import com.wn.dbms.entity.UserTest;
import com.wn.dbms.mapper.UserTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j //lombok的日志注解
@SpringBootTest
class WnDBMSApplicationTests {

    @Autowired
    UserTestMapper userTestMapper;

    UserTest userTest = new UserTest();

    @DisplayName("测试mybatis-plus")
    @Test
    void contextLoads() {
        //查
        List<UserTest> userTestList = userTestMapper.selectList( null);
        userTestList.forEach(System.out::println);
        //更
        /*User updateuser = new User(1,"root","123");
        int update = userMapper.update(updateuser,null);
        System.out.println(update);*/

        //插入
        /*user.setUsername("haker");
        user.setPassword("haker");
        int insert = userMapper.insert(user);
        log.warn("insert ==> {}",insert);*/

        //删除
        /*int delete = userTestMapper.deleteById(2);
        log.warn("delete ==> {}",delete); //返回1：成功*/


    }

}
