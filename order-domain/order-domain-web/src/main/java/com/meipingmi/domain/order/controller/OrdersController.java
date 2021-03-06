package com.meipingmi.domain.order.controller;



import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meipingmi.domain.oneid.facade.OneIdReadService;
import com.meipingmi.domain.order.entity.OrdersDO;
import com.meipingmi.domain.order.service.OrdersService;
import com.meipingmi.yeb.common.enums.ErrorCodeEnum;
import com.meipingmi.yeb.common.std.io.Result;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mpm
 * @since 2020-07-11
 */
@RestController
@RequestMapping(value = "/order/orders-do",produces = MediaType.APPLICATION_JSON_VALUE)
@RefreshScope
@Slf4j
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${mpm.name:}")
    private String value;
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private OneIdReadService oneIdReadService;

    @GetMapping("/queryOrdersAll/{pageNo}")
    @SentinelResource(value ="queryOrdersAll",blockHandler = "queryOrdersAllBlockHandler")
    public Result<List<OrdersDO>> queryOrdersAll(@PathVariable(name="pageNo") Integer pageNo){
        Page<OrdersDO> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(5);
        Page<OrdersDO> pageRes= ordersService.page(page);
        List<OrdersDO> list = pageRes.getRecords();
        return Result.ok(list);
    }

    @GetMapping("/queryOrder/{id}")
    @SentinelResource(value = "queryOrder",blockHandler = "queryOrderBlockHandler")
    public Result<OrdersDO> queryOrder(@PathVariable(name = "id") Long id){
        Long i = 1/id;
        OrdersDO ordersDO = ordersService.getById(id);
        ordersDO.setId(Long.MAX_VALUE);
        //需要做对象转化，转化成dto或vo对象
        stringRedisTemplate.opsForValue().set("k1",id+"");
        redisTemplate.opsForValue().set("k2",id);
        return Result.ok(ordersDO);
    }


    @GetMapping("/queryOrdersByName")
    public Result< List<OrdersDO>> queryOrdersByName(){
        List<OrdersDO> list = ordersService.selectByName(null);
        return Result.ok(list);
    }

    @GetMapping(value = "/config")
    public Result<String> config(){
        String key ="lock_key";
        RLock rLock = redissonClient.getLock(key);
        try{

            //加锁
            rLock.lock();
            Object o = oneIdReadService.getBizNo();
            Result<String> obj = oneIdReadService.getBizNo();
            log.info("{}",obj);
            return Result.ok("成功",obj.getData());
            //return Result.ok("");
        }catch (Exception e){
            log.error("[OrdersController][config]error",e);
            return Result.fail(ErrorCodeEnum.SYSTEM_ERROR_B0001.getCode());
        }finally {
            rLock.unlock();
        }

    }

    public Result<OrdersDO> queryOrderBlockHandler (Long p, BlockException exception)
    {
        return Result.ok(null);
    }

    public Result<List<OrdersDO>> queryOrdersAllBlockHandler (Integer p, BlockException exception)
    {

        return Result.ok(new ArrayList<>());
    }

}

