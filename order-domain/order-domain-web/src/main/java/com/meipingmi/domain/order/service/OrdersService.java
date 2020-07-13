package com.meipingmi.domain.order.service;

import com.meipingmi.domain.order.entity.OrdersDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mpm
 * @since 2020-07-11
 */
public interface OrdersService extends IService<OrdersDO> {
    List<OrdersDO> selectByName(String name);
}
