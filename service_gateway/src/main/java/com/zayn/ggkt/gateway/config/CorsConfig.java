package com.zayn.ggkt.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
    //处理跨域
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        //配置允许的请求方式
        config.addAllowedMethod("*");
        //配置允许的请求源地址
        config.addAllowedOrigin("*");
        //配置允许的请求头
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置请求路径使用对应的配置方式
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
