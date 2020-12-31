package com.ibn.xinte;

import com.ibn.xinte.util.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String s = JWTUtils.generateToken(1L);
        System.out.println(s);
        Long aLong = JWTUtils.parseToken(s);
        System.out.println(aLong);
    }

}
