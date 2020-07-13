package com.meipingmi.domain.order.facade.impl;


import com.meipingmi.domain.order.common.Result;
import com.meipingmi.domain.order.facade.OrderReadService;
import org.springframework.web.bind.annotation.RestController;


/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/10-17:02
 */
@RestController
public class OrderReadServiceImpl implements OrderReadService
{

    @Override
    public Result<String> queryOrderInfo(Long id) {

        return Result.ok("查询订单信息成功","orderInfo");
    }
}
