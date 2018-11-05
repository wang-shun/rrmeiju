package com.caizhukui.rrmeiju.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.caizhukui.core.consts.ProfileConstant;
import com.google.common.cache.CacheBuilder;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 缓存配置，默认使用Redis缓存
 * 
 * @author caizhukui
 * @date 2018年4月10日
 */
@Configuration
@EnableCaching
@PropertySource("classpath:properties/redis.properties")
public class CacheConfig {

    /** 主机名，开发环境 */
    @Value("${redis.hostName.dev}")
    private String hostNameDev;

    /** 端口号，开发环境 */
    @Value("${redis.port.dev}")
    private int portDev;

    /** 密码，开发环境 */
    @Value("${redis.password.dev}")
    private String passwordDev;

    /** 主机名，生产环境 */
    @Value("${redis.hostName.prod}")
    private String hostNameProd;

    /** 端口号，生产环境 */
    @Value("${redis.port.prod}")
    private int portProd;

    /** 密码，生产环境 */
    @Value("${redis.password.prod}")
    private String passwordProd;

    /** 最大连接数，默认8 */
    @Value("${redis.maxTotal}")
    private int maxTotal;

    /** 最大空闲连接数，默认8 */
    @Value("${redis.maxIdle}")
    private int maxIdle;

    /** 最小空闲连接数，默认0 */
    @Value("${redis.minIdle}")
    private int minIdle;

    /** 在获取连接的时候检查有效性，默认false */
    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    /**  */
    @Value("${redis.testOnReturn}")
    private boolean testOnReturn;

    /** 在空闲时检查有效性，默认true */
    @Value("${redis.testWhileIdle}")
    private boolean testWhileIdle;

    @Bean
    public CacheManager concurrentMapCacheManager() {
        return new ConcurrentMapCacheManager();
    }
    
    @Bean
    public CacheManager hazelcastCacheManager(HazelcastInstance hazelcastInstance) {
        return new HazelcastCacheManager(hazelcastInstance);
    }
    
    @Bean
    public HazelcastInstance hazelcastInstance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }
    
    @Bean
    public Config config() {
        Config config = new Config();
        // config设置
        return config;
    }

    @Bean
    public CacheManager guavaCacheManager() {
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(10,
                TimeUnit.MINUTES);
        guavaCacheManager.setCacheBuilder(cacheBuilder);
        return guavaCacheManager;
    }

    @Bean
    @Primary
    public CacheManager redisCacheManager(RedisTemplate<String, String> redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    @Profile(ProfileConstant.DEV)
    public RedisConnectionFactory devRedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(hostNameDev);
        jedisConnectionFactory.setPort(portDev);
        //jedisConnectionFactory.setPassword(passwordDev);
        jedisConnectionFactory.setPassword("<%${Czk1391@Qrj1560}%>");
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        return jedisConnectionFactory;
    }

    @Bean
    @Profile(ProfileConstant.PROD)
    public RedisConnectionFactory prodRedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(hostNameProd);
        jedisConnectionFactory.setPort(portProd);
        jedisConnectionFactory.setPassword(passwordProd);
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        return jedisConnectionFactory;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        return jedisPoolConfig;
    }

}
