package com.fafa.mptestdemo.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mp的配置类
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-30 15:39
 */
@Configuration
@MapperScan("com.fafa.mptestdemo.mapper")
public class MpConfig {
    /**
     * 乐观锁插件(将其注册到Bean中)
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
