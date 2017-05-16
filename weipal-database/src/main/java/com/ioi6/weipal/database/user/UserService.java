package com.ioi6.weipal.database.user;

import com.ioi6.weipal.model.user.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * user service
 * Created by shicheng on 2017/5/11.
 */
public interface UserService {

    /**
     * get all user
     *
     * @return user list
     */
    List<User> getAllUser();

    /**
     * get user by id
     *
     * @param id user id
     * @return user
     */
    User getById(String id);

    /**
     * get user by email
     *
     * @param email user email
     * @return user
     */
    User getByEmail(String email);

    /**
     * get user by username
     *
     * @param username user username
     * @return user
     */
    User getByUserName(String username);

    /**
     * get user by email and password
     *
     * @param email    user email
     * @param password user password
     * @return user
     */
    User getByEmailAndPassword(String email, String password);

}
