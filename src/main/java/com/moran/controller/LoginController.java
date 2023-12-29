package com.moran.controller;

import cn.dev33.satoken.stp.StpUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : moran
 * @da
 * te : 2023/8/31 14:32
 */
@RestController
@RequestMapping("")
@AllArgsConstructor
public class LoginController {

    @PostMapping("/login")
    public String login() {
        StpUtil.login(1);
        return StpUtil.getTokenValue();
    }
}
