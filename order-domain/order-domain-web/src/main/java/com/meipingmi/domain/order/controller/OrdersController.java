package com.meipingmi.domain.order.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meipingmi.domain.order.common.Result;
import com.meipingmi.domain.order.entity.OrdersDO;
import com.meipingmi.domain.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mpm
 * @since 2020-07-11
 */
@RestController
@RequestMapping("/order/orders-do")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/queryOrdersAll/{pageNo}")
    public Result< List<OrdersDO>> queryOrdersAll(@PathVariable(name="pageNo") Integer pageNo){
        Page<OrdersDO> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(5);
        Page<OrdersDO> pageRes= ordersService.page(page);
        List<OrdersDO> list = pageRes.getRecords();
        return Result.ok(list);
    }

    @GetMapping("/queryOrder/{id}")
    public Result< OrdersDO> queryOrder(@PathVariable(name = "id") Long id){

        OrdersDO ordersDO = ordersService.getById(id);
        //需要做对象转化，转化成dto或vo对象
        return Result.ok(ordersDO);
    }

    @GetMapping("/queryOrdersByName")
    public Result< List<OrdersDO>> queryOrdersByName(){
        List<OrdersDO> list = ordersService.selectByName(null);
        return Result.ok(list);
    }

    @GetMapping("/queryOrders")
    public Result<String> queryOrders(){
        return Result.ok("123");
    }


}

