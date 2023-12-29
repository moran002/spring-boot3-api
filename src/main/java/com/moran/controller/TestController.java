package com.moran.controller;

import com.moran.conf.bean.RestResult;
import com.moran.model.Test;
import com.moran.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : moran
 * @date : 2023/12/20 17:06
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;

    /**
     * 事物
     * @author :moran
     * @date :2023/12/22 10:10
     **/
    @GetMapping("/test")
    public RestResult test() {
        testService.transactional();
        return RestResult.success();
    }

    /**
     * 测试weekend 是否可以作为多次的参数
     * @author :moran
     * @date :2023/12/22 10:11
     **/
    @GetMapping("/test2")
    public RestResult test2() {
        testService.more();
        return RestResult.success();
    }
}
