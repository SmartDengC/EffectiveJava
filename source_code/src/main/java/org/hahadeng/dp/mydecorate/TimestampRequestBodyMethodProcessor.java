package org.hahadeng.dp.mydecorate;

// import dhh.project.dp.mydecorate.annotion.TimestampRequestBody;

import org.hahadeng.dp.mydecorate.annotion.TimestampRequestBody;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.List;
import java.util.Map;

/**
 * 时间解析器
 * <a href="https://www.bilibili.com/video/BV1bgPBesENK?spm_id_from=333.788.videopod.sections&vd_source=35e7dde81183ac464990a0a0ab794bce">...</a>
 *
 * @author 邓聪
 * @since 2025/6/3 19:30
 */
public class TimestampRequestBodyMethodProcessor implements HandlerMethodArgumentResolver {

    //  装饰这个processor
    private RequestResponseBodyMethodProcessor processor;

    ApplicationContext context;

    public TimestampRequestBodyMethodProcessor(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TimestampRequestBody.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        setupProcessor();
        Object o = processor.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        if (!(o instanceof Map<?, ?>)) {
            return o;
        }
        ((Map) o).put("timestamp", System.currentTimeMillis());
        return o;
    }

    private void setupProcessor() {
        if (this.processor != null) {
            return;
        }
        RequestMappingHandlerAdapter adapter = this.context.getBean(RequestMappingHandlerAdapter.class);
        List<HandlerMethodArgumentResolver> argumentResolvers = adapter.getArgumentResolvers();
        for (HandlerMethodArgumentResolver resolver : argumentResolvers) {
            if (resolver instanceof RequestResponseBodyMethodProcessor) {
                this.processor = (RequestResponseBodyMethodProcessor) resolver;
                return;
            }
        }


    }
}
