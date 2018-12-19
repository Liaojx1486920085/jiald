package com.baizhi.Interceptors;

import com.baizhi.entity.Admin;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * SpringBoot拦截器
 * */
@Component//让工厂创建实例化拦截器对象
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("1.拦截请求-------");
        String currentURL = request.getRequestURI();
        String ctxPath = request.getContextPath();
        //除掉项目名称时访问页面当前路径
        String targetURL = currentURL.substring(ctxPath.length());
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if ("/login.jsp".equals(targetURL)) {
            if (admin != null) {
                response.sendRedirect(request.getContextPath() + "/main/main.jsp");
                return false;
            } else {
                return true;//true为放行，false为拦截
            }
        } else if ("/main/main.jsp".equals(targetURL)) {
            if (admin != null) {
                return true;//true为放行，false为拦截
            } else {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return false;
            }
        } else if (!targetURL.equals("/main/main.jsp") || !targetURL.equals("/login.jsp")) {
            return true;//true为放行，false为拦截
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("2.拦截响应------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("3.拦截后异常处理");
    }
}
