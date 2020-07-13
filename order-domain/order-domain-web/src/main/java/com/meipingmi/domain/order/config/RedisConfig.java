package com.meipingmi.domain.order.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/13-20:28
 */
@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> template =new RedisTemplate<>();
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer=new FastJsonRedisSerializer<>(Object.class);
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(fastJsonRedisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;

    }

}
