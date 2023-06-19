package com.wn.dbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wn.dbms.entity.TableField;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TableFieldMapper extends BaseMapper<TableField> {

    int addTableFieldByNoKey(@Param("tableName") String tableName,
                             @Param("fieldName") String fieldName,
                             @Param("fieldType") String fieldType,
                             @Param("fieldLength") String fieldLength,
                             @Param("ifNull") String ifNull,
                             @Param("fieldDesc") String fieldDesc);
    int addTableFieldByKey(@Param("tableName") String tableName,
                             @Param("fieldName") String fieldName,
                             @Param("fieldType") String fieldType,
                             @Param("fieldLength") String fieldLength,
                             @Param("key") String key,
                             @Param("ifNull") String ifNull,
                             @Param("fieldDesc") String fieldDesc);

    int createTableByNoKey(@Param("tableName") String tableName,
                    @Param("fieldName") String fieldName,
                    @Param("fieldType") String fieldType,
                    @Param("fieldLength") String fieldLength,
                    @Param("ifNull") String ifNull,
                    @Param("fieldDesc") String fieldDesc);

    int createTableByKey(@Param("tableName") String tableName,
                         @Param("fieldName") String fieldName,
                         @Param("fieldType") String fieldType,
                         @Param("fieldLength") String fieldLength,
                         @Param("key") String key,
                         @Param("ifNull") String ifNull,
                         @Param("fieldDesc") String fieldDesc);
}
