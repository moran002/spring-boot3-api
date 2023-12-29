package com.moran.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.moran.model.vo.UserInfo;
import com.moran.util.PageUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * @author : moran
 * @date : 2023/3/7 10:17
 */
public class Controller {

    /**
     * 开启分页
     */
    public void startPage() {
        PageUtil.startPage();
    }

    /**
     * 获取request
     * @author :moran
     * @date :2022/11/14 16:02
     **/
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    /**
     * 获取response
     * @author :moran
     * @date :2022/11/14 16:03
     **/
    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
    }
    /**
     * 获取用户ID
     */
    public UserInfo getUserInfo() {
        return (UserInfo) StpUtil.getSession().get("userInfo");
    }
    /**
     * 获取用户ID
     */
    public Long getUserId() {
        return getUserInfo().getUserId();
    }
}
