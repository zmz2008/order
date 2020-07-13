package com.meipingmi.domain.order.config;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/11-11:50
 */

import com.baomidou.mybatisplus.core.injector.ISqlInjector;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.meipingmi.domain.order.mapper")
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {

    /**
     * @Author : wuzhifei
     * @Description : 注册乐观锁插件
     * @Date : 2020/7/11-14:51
     * @Param : []
     * @return : com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
     **/
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * @Author : wuzhifei
     * @Description : 分页插件
     * @Date : 2020/7/11-14:52
     * @Param : []
     * @return : com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     **/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return  new PaginationInterceptor();
    }


}

