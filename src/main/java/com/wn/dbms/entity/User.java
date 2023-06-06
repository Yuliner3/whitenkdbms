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
@TableName("u_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer uId;
    private String uAccount;
    private String uPassword;
    private String uTel;
    private String uEmail;
    private String uHost;

    public User(String uAccount, String uPassword, String uTel, String uEmail,String uHost) {
        this.uAccount = uAccount;
        this.uPassword = uPassword;
        this.uTel = uTel;
        this.uEmail = uEmail;
        this.uHost = uHost;
    }
}
