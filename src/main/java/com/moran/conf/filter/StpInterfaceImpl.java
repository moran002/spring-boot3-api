package com.moran.conf.filter;

import cn.dev33.satoken.stp.StpInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : moran
 * @date : 2023/2/28 9:48
 */
@Component
@AllArgsConstructor
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        //查询当前用户角色放入集合
        return null;
    }
}
