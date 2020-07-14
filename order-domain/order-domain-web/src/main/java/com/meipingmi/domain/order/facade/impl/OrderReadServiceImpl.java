package com.meipingmi.domain.order.facade.impl;


import cn.hutool.core.bean.BeanUtil;
import com.meipingmi.domain.order.common.Result;
import com.meipingmi.domain.order.dto.OrderDTO;
import com.meipingmi.domain.order.entity.OrdersDO;
import com.meipingmi.domain.order.facade.OrderReadService;
import com.meipingmi.domain.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/10-17:02
 */
@RestController
public class OrderReadServiceImpl implements OrderReadService
{
    @Autowired
    private OrdersService ordersService;

    @Override
    public Result<OrderDTO> queryOrderInfo(Long id) {
        OrdersDO ordersDO = ordersService.getById(id);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtil.copyProperties(ordersDO,orderDTO);
        return Result.ok(orderDTO);
    }
}
