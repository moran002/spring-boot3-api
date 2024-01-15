package com.moran.service.impl;

import com.moran.model.entity.Test;
import com.moran.mapper.TestMapper;
import com.moran.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author moran
 * @since 2024-01-15 15:09:05
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
