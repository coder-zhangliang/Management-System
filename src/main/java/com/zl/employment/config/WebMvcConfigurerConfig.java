package com.zl.employment.config;

import com.zl.employment.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigurerConfig implements WebMvcConfigurer
{
    /**
     * 前后端地址不一样，需要解决跨域问题
     * @param registry  跨域注册
     */
    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")  //允许跨域的映射请求
                .allowCredentials(true)  // 允许发送Cookie
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .maxAge(3600);
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new UserInterceptor())  //添加指定的拦截器类
                .addPathPatterns("/**") //需要拦截的映射
                .excludePathPatterns("/RegisterAndLogin/login"); //排除不需要拦截的映射
    }

    /**
     * 添加文件上传
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver()
    {
        return new StandardServletMultipartResolver();
    }

    /**
     * 配置静态资源的映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        String path = Thread.currentThread().getContextClassLoader().getResource("static").getPath();
        path = path.substring(1, path.length()).replace("\\", "/");
        path = path + "/resumes/";

        registry.addResourceHandler("/resumes/**")
                .addResourceLocations("file:" + path);

    }
}
