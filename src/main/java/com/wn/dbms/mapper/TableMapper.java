package com.wn.dbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wn.dbms.entity.Table;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableMapper extends BaseMapper<Table> {
}
