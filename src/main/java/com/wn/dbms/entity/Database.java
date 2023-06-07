package com.wn.dbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data               //省略get、set、toString方法
@TableName("d_database")
public class Database {
    @TableId(type = IdType.AUTO)
    private Integer dId;
    private String dName;
    private String dCharset;

}
