package com.ioi6.weipal.database.user.mapper;

import com.ioi6.weipal.model.user.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * user mapper
 * Created by shicheng on 2017/5/11.
 */
public interface UserMapper {

    /**
     * get all user
     *
     * @return user list
     */
    @Select(value = "SELECT id, username, password, email, enable, locked, deleted, createTime, imageUrl FROM user")
    List<User> getAllUser();

    /**
     * get user by id
     *
     * @param id user id
     * @return user
     */
    @Select(value = "SELECT id, username, password, email, enable, locked, deleted, createTime, imageUrl FROM user " +
            "WHERE id = #{id}")
    User getById(String id);

    /**
     * get user by email
     *
     * @param email user email
     * @return user
     */
    @Select(value = "SELECT id, username, password, email, enable, locked, deleted, createTime, imageUrl FROM user " +
            "WHERE email = #{email}")
    User getByEmail(String email);

    /**
     * get user by username
     *
     * @param username user username
     * @return user
     */
    @Select(value = "SELECT id, username, password, email, enable, locked, deleted, createTime, imageUrl FROM user " +
            "WHERE username = #{username}")
    User getByUserName(String username);

    /**
     * get user by email and password
     *
     * @param email    user email
     * @param password user password
     * @return user
     */
    @Select(value = "SELECT id, username, password, email, enable, locked, deleted, createTime, imageUrl FROM user " +
            "WHERE email = #{email} and password = #{password}")
    User getByEmailAndPassword(String email, String password);

}
