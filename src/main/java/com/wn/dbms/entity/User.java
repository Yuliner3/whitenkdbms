package com.wn.dbms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User {
    @TableId(value = "u_id")
    private Integer uId;
    private String uAccount;
    private String uPassword;
    private String uTel;
    private String uEmail;
}
