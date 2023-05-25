package com.wn.dbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wn.dbms.entity.Query;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryMapper extends BaseMapper<Query> {
}
