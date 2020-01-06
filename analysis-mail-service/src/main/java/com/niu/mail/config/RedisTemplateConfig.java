package com.niu.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @program: analysis-mail
 * @description: redis配置
 * @author: zhengzz
 * @create: 2020-01-05 23:15
 **/
@Configuration
public class RedisTemplateConfig {
    @Bean
    public RedisTemplate<String, Object>redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object>template=new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);
        //设置key的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化器
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        //template.setValueSerializer(new StringRedisSerializer());
        return template;
    }

    @Bean
    public EmailServerCacheLoader getEmailServer(RedisTemplate redisTemplate) {
        return new EmailServerCacheLoader();
    }
}
