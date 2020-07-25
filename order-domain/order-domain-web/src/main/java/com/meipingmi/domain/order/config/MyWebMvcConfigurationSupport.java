package com.meipingmi.domain.order.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/13-19:41
 */

//@Component
public class MyWebMvcConfigurationSupport extends WebMvcConfigurationSupport {

    /**
     * 使用fastjson作为JSON消息转换器
     * 使用StringHttpMessageConverter作为String消息转换器
     * <p>
     * 注: 一般来讲，这两个消息消息转换器就是用于绝大部分情况了;
     * 如果业务环境情况等比较特殊，需要其他的消息转换器，
     * 那么再追加新的转换器即可
     * <p>
     * 注:JSON消息转换器需要引入fastjson依赖
     * StringHttpMessageConverter消息转换器需要引入springframework依赖
     *
     * @date 2019/8/14 13:06
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        /// -> JSON消息转换器(采用阿里的fastjson)
        // 创建一个转换器对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        // 个性化配置转换特性
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 配置:要格式化返回的json数据
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 配置:把空的值的key也返回
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        // 字段如果为null,输出为false,而非null
        //fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullBooleanAsFalse);
        // 数值字段如果为null,输出为0,而非null
        //fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullNumberAsZero);
        // List字段如果为null,输出为[],而非null;
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty);
        // 字符类型字段如果为null,输出为"",而非null
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
        // 将中文都会序列化为\\u XXXX格式，字节数会多一些 (Long转为String),再通过浏览器解析中文
        //fastJsonConfig.setSerializerFeatures(SerializerFeature.BrowserCompatible);
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(Long.class , ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE , ToStringSerializer.instance);
        fastJsonConfig.setSerializeConfig(serializeConfig);

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        // 处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>(4);
        fastMediaTypes.add(new MediaType("application", "json",Charset.forName("UTF-8")));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);

        /// -> String消息转换器
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setDefaultCharset(Charset.forName("UTF-8"));
        stringConverter.setSupportedMediaTypes(fastMediaTypes);

        // 将convert添加到converters当中.
        converters.add(fastJsonHttpMessageConverter);
        converters.add(stringConverter);
        super.configureMessageConverters(converters);
    }

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
