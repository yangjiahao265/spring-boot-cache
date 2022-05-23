package com.example.springbootcache;

import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableCaching
@AllArgsConstructor
public class TestCacheImpl implements TestCache {

//    private CacheResolver cacheResolver;

    private CacheManager cacheManager;

    private RedisTemplate stringStringRedisTemplate;

    @Override
    @Cacheable(cacheNames = {"hello"})
//    @CachePut(cacheNames = {"hello"}, key = "1")1
//    @CacheEvict(cacheNames = {"hello"}, key = "1")
    public String hello() {
//        System.out.println(cacheResolver);
        System.out.println(cacheManager);
        stringStringRedisTemplate.opsForList().size()
//        stringStringRedisTemplate.opsForValue().set("1", "1");
        return "hello";
    }
}
