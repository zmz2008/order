package com.meipingmi.domain.order.facade;

import org.springframework.cloud.openfeign.FeignClient;

/***
 * @Author : wuzhifei
 * @Date : 2020/7/10-16:09
 * @Description : TODO
 * @Jdk : 1.8
 */
@FeignClient("order-domain")
public interface OrderWriteService {
}
