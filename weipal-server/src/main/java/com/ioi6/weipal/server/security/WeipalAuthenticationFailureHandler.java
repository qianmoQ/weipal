package com.ioi6.weipal.server.security;

import com.ioi6.weipal.server.config.SecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * failure
 * Created by shicheng on 2017/5/11.
 */
@Component
@Slf4j
public class WeipalAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        saveException(request, exception);
        String redirectUrl = SecurityConfig.LOGIN_PAGE_URL;
        String username = request.getParameter("username");
        if (!StringUtils.isEmpty(username)) {
            redirectUrl = SecurityConfig.LOGIN_ERROR_URL + "?u=" + username;
        }
        log.info("{} login error redirecting to {}", username, redirectUrl);
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }

}
