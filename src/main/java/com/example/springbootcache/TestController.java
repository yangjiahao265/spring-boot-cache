package com.example.springbootcache;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
@AllArgsConstructor
public class TestController {

    private TestCache testCache;

    @GetMapping
    public String test1() {
        return testCache.hello();
    }

}
