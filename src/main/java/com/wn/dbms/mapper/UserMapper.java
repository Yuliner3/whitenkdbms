package com.wn.dbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wn.dbms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update u_user set u_password = #{uPassword} where u_id = #{uId}")
    Integer updatePwdById(@Param("uPassword") String password,@Param("uId") Integer id);

    User findUserById(Integer id);
}
