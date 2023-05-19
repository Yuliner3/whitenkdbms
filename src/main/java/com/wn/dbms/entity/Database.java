package com.wn.dbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@TableName("d_database")
public class Database {
    @TableId(type = IdType.AUTO)
    private Integer dId;
    private String dName;
    private String dCharset;
    private Integer uId;
}
