package top.yannyi.courtyardWu;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: LeahAna
 * @Date: 2025/1/20 11:38
 * @Desc:
 */

@Slf4j
@SpringBootApplication
@MapperScan("top.yannyi.courtyardWu.dao")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
        log.info(" courtyard-wu backend server start... ");
    }
}
