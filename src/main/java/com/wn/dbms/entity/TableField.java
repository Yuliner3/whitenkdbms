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
    private String fieldLength;
    private int ifNull;
    private int ifKey;
    private String fieldDesc;

    public TableField(String fieldName, String fieldType, String fieldLength, int ifNull, int ifKey, String fieldDesc) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldLength = fieldLength;
        this.ifNull = ifNull;
        this.ifKey = ifKey;
        this.fieldDesc = fieldDesc;
    }
}
