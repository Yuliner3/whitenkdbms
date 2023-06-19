package com.wn.dbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wn.dbms.entity.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TableMapper extends BaseMapper<Table> {

    int ifExistTable(@Param("tableName") String tableName);

    void dropTable(@Param("tableName") String tableName);
}
