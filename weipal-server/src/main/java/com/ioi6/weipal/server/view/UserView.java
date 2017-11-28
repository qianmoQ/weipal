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
package com.ioi6.weipal.server.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * user view
 * Created by shicheng on 2017/5/11.
 */
@Controller
@RequestMapping(value = "user")
public class UserView {

    /**
     * login view
     *
     * @return login page
     */
    @RequestMapping(value = {"login", "signIn"}, method = RequestMethod.GET)
    String login() {
        return "login";
    }

    /**
     * login view
     *
     * @return login page
     */
    @RequestMapping(value = {"logout", "signOut"}, method = RequestMethod.GET)
    String logout() {
        return "redirect:/logout";
    }

    /**
     * login error view
     *
     * @return
     */
    @RequestMapping(value = {"login/error", "signIn"}, method = RequestMethod.GET)
    ModelAndView loginError(@RequestParam(required = false, name = "u") String username) {
        ModelAndView view = new ModelAndView("login");
        view.addObject("usernamePasswordWrong", true);
        view.addObject("username", username);
        return view;
    }

    /**
     * register view
     *
     * @return register page
     */
    @RequestMapping(value = {"register", "signUp"}, method = RequestMethod.GET)
    String register() {
        return "register";
    }

}
