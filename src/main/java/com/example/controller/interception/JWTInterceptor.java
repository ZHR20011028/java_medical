package com.example.controller.interception;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.exception.TokenAuthExpiredException;
import com.example.utils.Code;
import com.example.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/20
 * @Description: com.example.controller.interception
 * @Version: 1.0
 */
@Component
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getMethod().equals("OPTIONS")){
            Cookie[] cookies = request.getCookies();
            String token = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("token".equals(cookie.getName())) {
                        token = cookie.getValue();
                        break;
                    }
                }
            }
            System.out.println(token);
            if (token == null || token.isEmpty()) {
                throw new TokenAuthExpiredException(Code.LOGIN_TOKEN_NULL, "token不能为空");
            }
            try {
                JWTUtil.verify(token);
            } catch (SignatureVerificationException e) {
                log.error("无效签名！ 错误 ->", e);
                return false;
            } catch (TokenExpiredException e) {
                log.error("token过期！ 错误 ->", e);
                return false;
            } catch (AlgorithmMismatchException e) {
                log.error("token算法不一致！ 错误 ->", e);
                return false;
            } catch (Exception e) {
                log.error("token无效！ 错误 ->", e);
                return false;
            }
        }
        return true;
    }
}
