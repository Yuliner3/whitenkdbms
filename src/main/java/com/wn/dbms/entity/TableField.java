package com.wn.dbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("table_field")
public class TableField {
    @TableId(type = IdType.AUTO)
    private Integer tfId;
    private String fieldName;
    private String fieldType;
    private String fieldConstraint;


}
