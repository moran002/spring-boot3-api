package com.moran.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.IPage;
import com.moran.conf.bean.RestResult;
import com.moran.model.entity.Test;
import com.moran.service.ITestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;

/**
 * 测试demo类
 * @author moran
 * @since 2024-01-15 14:44:29
 */
@RestController
@RequestMapping("/demo")
@AllArgsConstructor
public class DemoController extends Controller {
    private final ITestService testService;

    /**
     * 获取列表
     *
     * @author :moran
     * @date :2024/1/15 15:10
     **/
    @GetMapping("/getList")
    public RestResult getList() {
        startPage();
        QueryWrapper<Test> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "门素身");
        return RestResult.success(testService.list(wrapper));
    }

    /**
     * 插入
     * @author :moran
     * @date :2024/1/15 15:19
     **/
    @PostMapping("/add")
    public RestResult addTest(@RequestBody Test test) {
        testService.save(test);
        return RestResult.success();
    }

    /**
     * 更新
     * @author :moran
     * @date :2024/1/15 15:20
     **/
    @PostMapping("/update")
    public RestResult updateTest(@RequestBody Test test) {
        testService.updateById(test);
        return RestResult.success();
    }

    /**
     * 删除
     * @author :moran
     * @date :2024/1/15 15:20
     **/
    @PostMapping("/delById")
    public RestResult delById(@RequestBody Test test) {
        testService.removeById(test.getId());
        return RestResult.success();
    }
}
