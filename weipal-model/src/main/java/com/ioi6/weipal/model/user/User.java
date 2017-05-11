package com.ioi6.weipal.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * user model
 * Created by shicheng on 2017/5/11.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private boolean enable;
    private boolean locked;
    private boolean deleted;
    private Date createTime;

}
