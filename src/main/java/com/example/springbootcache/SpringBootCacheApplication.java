package com.example.springbootcache;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@EnableCaching
@SpringBootApplication
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }

}

@RestController
@RequestMapping("/cache")
@AllArgsConstructor
class CacheController {

    private final CacheManager cacheManager;

    @GetMapping
    public String test1() {
        Collection<String> cacheNames = cacheManager.getCacheNames();
        String hello = hello();
        return hello;
    }

    @Caching(
            put = {@CachePut(cacheNames = {"hello"}, key = "1")})
    public String hello() {
        return "hello";
    }

}
