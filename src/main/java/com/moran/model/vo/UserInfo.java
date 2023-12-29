package com.moran.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : moran
 * @date : 2023/3/7 10:07
 */
@Setter
@Getter
public class UserInfo {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 账号
     */
    private String username;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 用户名称
     */
    private String nickName;
}
