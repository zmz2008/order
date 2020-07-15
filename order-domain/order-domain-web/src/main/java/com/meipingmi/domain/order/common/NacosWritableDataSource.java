package com.meipingmi.domain.order.common;

import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Properties;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/14-20:59
 */
@Component
@RefreshScope
public class NacosWritableDataSource<T> implements WritableDataSource<T> {

    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.server-addr}")
    private String remoteAddress;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.groupId}")
    private String groupId;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.namespace}")
    private String namespace;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.dataId}")
    private String dataId;

    @Override
    public void write(T o) throws Exception {
        String jsonConfigInfo = encodeJson(o);
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, remoteAddress);
        properties.put(PropertyKeyConst.NAMESPACE, namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        configService.publishConfig(dataId, groupId, jsonConfigInfo);
    }

    private <T> String encodeJson(T t) {
        return JSON.toJSONString(t);
    }

    @Override
    public void close() throws Exception {

    }
}
