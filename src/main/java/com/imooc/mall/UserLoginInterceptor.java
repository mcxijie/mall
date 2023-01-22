package com.imooc.mall;

import com.imooc.mall.exception.UserLoginException;
import com.imooc.mall.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.imooc.mall.consts.MallConst.CURRENT_USER;

public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //true表示继续流程，false表示中断
        User user = (User) request.getSession().getAttribute(CURRENT_USER);
        if (user == null) {
            throw new UserLoginException();
//            return ResponseVo.error(NEED_LOGIN);
        }
        return true;

    }
}
