package com.meipingmi.domain.order.facade;

import com.meipingmi.domain.order.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient("order-domain")
public interface OrderReadService {

    @GetMapping(value = "/queryOrderInfo")
    Result<String> queryOrderInfo(@RequestParam(name = "id") Long id);

}
