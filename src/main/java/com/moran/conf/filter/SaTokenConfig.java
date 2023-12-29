package com.moran.conf.filter;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.moran.conf.exception.ServiceException;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 路由拦截鉴权
 * @author :moran
 * @date :2023/8/29 15:43
 **/
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {
    @Resource
    private IgnoreUrlsConfig ignoreUrlsConfig;

    /**
     * 注册Sa-Token全局过滤器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handler -> {
                    //白名单只需要登录即可
                    SaRouter.match(ignoreUrlsConfig.getUrls())
                            .check(r -> StpUtil.checkLogin()).stop();
                    throw new ServiceException("请登录");
                })).addPathPatterns("/**")
                .excludePathPatterns("/login","/test/**");
    }
}
