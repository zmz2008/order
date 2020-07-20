package com.meipingmi.domain.order.facade;



import com.meipingmi.common.std.io.Result;
import com.meipingmi.domain.order.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("order-domain")
@RequestMapping("/order")
public interface OrderReadService {

    @GetMapping(value = "/queryOrderInfo")
    Result<OrderDTO> queryOrderInfo(@RequestParam(name = "id") Long id);

}
