package com.moran.conf.listener;

import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author : moran
 * @date : 2023/12/25 8:51
 */
public class RedisListener {
    @Resource
    private RedisConnectionFactory redisConnectionFactory;
    /**
     * 过期事件接收
     * 由于过期事件,在接收之前会先删除数据再推送过期的key,所以只能利用key来进行数据处理
     * @author :moran
     * @date :2023/10/27 15:31
     **/
    @Bean
    public RedisMessageListenerContainer container() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        // 订阅所有db的过期事件
        container.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] pattern) {
                String expiredKey = message.toString();
                if (expiredKey.startsWith("order:")) {
                    System.out.println(JSONUtil.toJsonStr(expiredKey));
                    // 处理订单超时逻辑
                    String orderId = expiredKey.split(":")[1];
                    // 这里调用你的服务类方法，处理订单超时逻辑
                    // orderService.cancelOrder(orderId);
                    System.out.println(JSONUtil.toJsonStr(orderId));
                }
            }
        }, new PatternTopic("__keyevent@*__:expired"));
        return container;
    }
}
