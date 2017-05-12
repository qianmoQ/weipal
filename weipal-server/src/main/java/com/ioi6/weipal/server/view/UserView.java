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
