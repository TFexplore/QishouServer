package com.zhaishu.qishouserver.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
 
/**
 * @Author: Choj
 * @CreateDateTime: 2020/1/14 20:46
 * @ModifyDateTime:
 * @Name: UserMapperConfig
 * @Description: 修改用户信息拦截器
 * @Since: 1.0
 **/
@Configuration
@Component
public class MapperConfig {
 
    /**
     * 注册插件
     *
     * @return UserInterceptor
     */
    @Bean
    public String myInterceptor(final SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addInterceptor(new MybatisInterceptor());
        return null;
    }
}