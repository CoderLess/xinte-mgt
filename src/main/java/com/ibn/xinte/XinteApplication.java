package com.ibn.xinte;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan({"com.ibn.xinte.dao"})
@EnableSwagger2
public class XinteApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinteApplication.class, args);
        System.out.println("http://localhost:8080/swagger-ui.html");
        System.out.println("http://localhost:8080/doc.html");
    }

}
