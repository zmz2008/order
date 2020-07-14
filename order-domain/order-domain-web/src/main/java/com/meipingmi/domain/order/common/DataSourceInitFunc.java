package com.meipingmi.domain.order.common;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.transport.util.WritableDataSourceRegistry;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/14-19:52
 */
@Component
public class DataSourceInitFunc implements InitFunc{

    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.server-addr}")
    private String remoteAddress;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.groupId}")
    private String groupId;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.namespace}")
    private String namespace;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.dataId}")
    private String dataId;
    @Autowired
    private NacosWritableDataSource nacosWritableDataSource;

    @PostConstruct
    @Override
    public void init() throws Exception {
//        final String remoteAddress = "localhost";
//        final String groupId = "Sentinel:Demo";
//        final String dataId = "com.alibaba.csp.sentinel.demo.flow.rule";
//
//        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId,
//                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
//        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());


        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, remoteAddress);
        properties.put(PropertyKeyConst.NAMESPACE, namespace);

        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(properties, groupId, dataId,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
        WritableDataSourceRegistry.registerFlowDataSource(nacosWritableDataSource);
    }

}
