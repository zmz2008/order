package com.meipingmi.domain.order.facade.impl;

import com.meipingmi.common.vo.WebResult;
import com.meipingmi.domain.order.facade.OrderReadService;
import org.springframework.web.bind.annotation.RestController;


/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/10-17:02
 */
@RestController
public class OrderReadServiceImpl implements OrderReadService {

    @Override
    public WebResult<String> queryOrderInfo(Long id) {

        return WebResult.buildSucc("查询成功") ;
    }
}
