package com.meipingmi.domain.order.mapper;

import com.meipingmi.domain.order.entity.OrdersDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mpm
 * @since 2020-07-11
 */
public interface OrdersMapper extends BaseMapper<OrdersDO> {
    //@Select("SELECT * FROM orders where id = 1")
    List<OrdersDO> selectByName2(@Param("name") String name);

}
