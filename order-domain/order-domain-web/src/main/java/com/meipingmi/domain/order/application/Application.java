package com.meipingmi.domain.order.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Author : wuzhifei
 * @Description : //TODO 
 * @Date : 2020/7/10-17:02
 * @Param : 
 * @return : 
 **/
@SpringBootApplication(scanBasePackages = {"com.meipingmi.order"})
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
