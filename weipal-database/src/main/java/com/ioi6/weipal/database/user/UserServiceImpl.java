package com.ioi6.weipal.database.user;

import com.ioi6.weipal.database.user.mapper.UserMapper;
import com.ioi6.weipal.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shicheng on 2017/5/11.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getById(String id) {
        return userMapper.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userMapper.getByEmail(email);
    }

    @Override
    public User getByUserName(String username) {
        return userMapper.getByUserName(username);
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        return userMapper.getByEmailAndPassword(email, password);
    }

}
