package com.meipingmi.domain.order.service.impl;

import com.meipingmi.domain.order.entity.OrdersDO;
import com.meipingmi.domain.order.mapper.OrdersMapper;
import com.meipingmi.domain.order.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mpm
 * @since 2020-07-11
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, OrdersDO> implements OrdersService {

    @Override
    public List<OrdersDO> selectByName(String name) {

        return baseMapper.selectByName2(null);
    }
}
