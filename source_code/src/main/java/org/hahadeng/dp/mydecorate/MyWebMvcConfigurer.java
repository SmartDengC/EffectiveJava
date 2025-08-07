package org.hahadeng.dp.mydecorate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author 邓聪
 * @since 2025/6/3 19:44
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    ApplicationContext applicationContext;
    // RequestMappingHandlerAdapter requestMappingHandlerAdapter;


    /**
     * 将自己定义的解析器放到解析器列表中
     *
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new TimestampRequestBodyMethodProcessor(applicationContext));
    }
}
