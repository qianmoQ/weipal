/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
