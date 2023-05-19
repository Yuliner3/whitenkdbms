package com.wn.dbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@TableName("v_view")
public class View {
    @TableId(type = IdType.AUTO)
    private Integer vId;
    private String vName;
    private Integer dId;
}
