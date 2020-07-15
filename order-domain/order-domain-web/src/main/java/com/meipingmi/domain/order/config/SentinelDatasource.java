package com.meipingmi.domain.order.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/15-10:02
 */
@Data
@Component
@RefreshScope
public class SentinelDatasource {

    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.server-addr}")
    private String remoteAddress;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.groupId}")
    private String groupId;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.namespace}")
    private String namespace;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.dataId}")
    private String dataId;

}
