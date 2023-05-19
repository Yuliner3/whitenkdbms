package com.wn.dbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@TableName("dts_table")
public class DTSTable {
    @TableId(type = IdType.AUTO)
    private Integer dtsId;
    private String dtsName;
    private String dtsContent;
    private Integer tId;


}
