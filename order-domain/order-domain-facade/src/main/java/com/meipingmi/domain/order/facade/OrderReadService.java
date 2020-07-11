package com.meipingmi.domain.order.facade;

import com.meipingmi.common.vo.WebResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient("order-domain")
public interface OrderReadService {

    @GetMapping(value = "/queryOrderInfo")
    WebResult<String> queryOrderInfo(@RequestParam(name = "id") Long id);

}
