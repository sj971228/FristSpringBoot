package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private Integer sex;
}
