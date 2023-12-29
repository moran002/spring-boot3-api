package com.moran.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.moran.mapper.TestMapper;
import com.moran.model.Test;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

/**
 * @author : moran
 * @date : 2023/12/20 17:05
 */
@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    @Transactional(rollbackFor = Exception.class)
    public void transactional() {
        for (int i = 0; i < 10; i++) {
            Test test = new Test();
            test.setId(IdUtil.getSnowflakeNextId());
            test.setName("测试" + i);
            test.setTableName("test_2023");
            testMapper.insertSelective(test);
        }
    }
    /**
     * 测试一个example是否可以多次利用
     * @author :moran
     * @date :2023/12/22 14:37
     **/
    public void more() {
        Weekend<Test> weekend = Weekend.of(Test.class);
        weekend.setTableName("test_2023");
        weekend.weekendCriteria().andEqualTo(Test::getName, "测试5");
        List<Test> list = testMapper.selectByExample(weekend);
        System.out.println(JSONUtil.toJsonStr(list));
        weekend.weekendCriteria().andEqualTo(Test::getName, "测试6");
        System.out.println(JSONUtil.toJsonStr(testMapper.selectByExample(weekend)));
    }
}
