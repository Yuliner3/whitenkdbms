package com.wn.dbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@TableName("q_query")
public class Query {
    @TableId(type = IdType.AUTO)
    private Integer qId;
    private String qName;
    private Integer dId;

}
