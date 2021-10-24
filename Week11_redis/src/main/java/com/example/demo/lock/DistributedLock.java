package com.example.demo.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;


@Component
public class DistributedLock {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private DistributedLock(){};

    private static class SingletonInstance {
        private static final DistributedLock INSTANCE = new DistributedLock();
    }
    
    public static DistributedLock getInstance(){
        return SingletonInstance.INSTANCE;
    }
    /**
     * 获得锁
     */
    public boolean getLock(String lockId, long millisecond) {
        Boolean success = stringRedisTemplate.opsForValue().setIfAbsent(lockId, "lock",
                millisecond, TimeUnit.MILLISECONDS);
        return success != null && success;
//        try(Jedis jedis = jedisPool.getResource()) {
//            return "OK".equals(jedis.set(lockId, lockId, "NX", "EX", millisecond));
//        }
    }

    public void releaseLock(String lockId) {
        stringRedisTemplate.delete(lockId);
    }

}
