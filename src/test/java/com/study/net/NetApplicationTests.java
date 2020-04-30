package com.study.net;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@SpringBootApplication
class NetApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void sendMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "BroadCastingPubsub " + i;

            Map<Object, Object> map = new HashMap<>();
            map.put("test", message);

            redisTemplate.opsForStream().add("BROADCASTING_STREAM_MQ_KEY", map);
            System.out.printf("send message BroadCastingPubsub %d \n", i);
        }
    }
}
