package com.ioi6.weipal.server.security;

import com.ioi6.weipal.server.config.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * login success
 * Created by shicheng on 2017/5/11.
 */
@Component
public class WeipalAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    public WeipalAuthenticationSuccessHandler() {
        super.setTargetUrlParameter(SecurityConfig.TARGET_URL_PARAMETER);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        //添加登陆日志
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
