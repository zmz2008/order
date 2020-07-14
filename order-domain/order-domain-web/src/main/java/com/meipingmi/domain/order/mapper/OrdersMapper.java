package com.meipingmi.domain.order.mapper;

import com.meipingmi.domain.order.entity.OrdersDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;


@CacheNamespace(implementation= RedisCache.class,eviction=RedisCache.class)
public interface OrdersMapper extends BaseMapper<OrdersDO> {

    List<OrdersDO> selectByName2(@Param("name") String name);

}
