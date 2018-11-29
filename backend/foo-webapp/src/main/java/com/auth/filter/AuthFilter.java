package com.auth.filter;

import com.auth.service.TokenService;
import com.foo.dto.AuthUser;
import com.foo.dto.UserContext;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthFilter implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserContext userContext;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        try {
            Claims verifyResult = this.tokenService.verifyToken(authHeader);
            logger.info(verifyResult.toString());

            AuthUser authUser = new AuthUser(verifyResult);
            userContext.setAuthUser(authUser);

            return true;
        } catch (JwtException cje) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        userContext.clear();
    }
}