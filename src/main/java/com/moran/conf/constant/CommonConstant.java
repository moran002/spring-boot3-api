package com.moran.conf.constant;

/**
 * @author 刘云
 * @date 2021/7/14
 * 项目通用常量池
 **/
public final class CommonConstant {


    private CommonConstant() {
        throw new RuntimeException("can not init constant class");
    }

    /**
     * 请求头
     */
    public static final String HEADER = "Authorization";

    public static final String START_WITH = "Bearer ";

    /**
     * 成功字符串
     */
    public static final String SUCCESS = "success";
}
