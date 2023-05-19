package com.wn.dbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@TableName("t_table")
public class Table {
    @TableId(type = IdType.AUTO)
    private Integer tId;
    private String tName;
    private String tDesc;
    private Integer dId;
    private Integer uId;
}
