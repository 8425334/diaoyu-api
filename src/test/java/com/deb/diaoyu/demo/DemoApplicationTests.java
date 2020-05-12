package com.deb.diaoyu.demo;

import com.deb.diaoyu.demo.security.jwt.JWT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private JWT jwt;

    @Test
    void contextLoads() {
        System.out.println(jwt.getToken("12345"));
    }

}
