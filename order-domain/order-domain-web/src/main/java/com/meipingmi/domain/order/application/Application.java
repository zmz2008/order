package com.meipingmi.domain.order.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author : wuzhifei
 * @Description : //TODO 
 * @Date : 2020/7/10-17:02
 * @Param : 
 * @return : 
 **/
@SpringBootApplication(scanBasePackages = {"com.meipingmi.domain.order"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.meipingmi.domain.oneid"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
