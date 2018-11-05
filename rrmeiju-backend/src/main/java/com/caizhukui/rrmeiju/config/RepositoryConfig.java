package com.caizhukui.rrmeiju.config;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.LocalCacheScope;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.caizhukui.core.consts.ProfileConstant;

/**
 * 数据源配置，默认使用Alibaba开源的Druid数据源
 * 
 * @author caizhukui
 * @date 2018年4月10日
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:properties/jdbc/druid.properties")
public class RepositoryConfig {
    
    /** Spring自动扫描的包名 */
    private static final String MAPPER_SCANNER_BASE_PACKAGE = "com.caizhukui.rrmeiju.mapper";
    
    /**  */
    private static final String TYPE_ALIASES_PACKAGE = "com.caizhukui.rrmeiju.model";
    
    /** MyBatis的Mapper文件的classpath路径 */
    private static final String MYBATIS_MAPPER_LOCATION = "classpath:mybatis/**/*Mapper.xml";

    /** JDBC驱动类的全限定类名 */
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    /** 数据库连接URL，开发环境 */
    @Value("${jdbc.url.dev}")
    private String urlDev;

    /** 用户名，开发环境 */
    @Value("${jdbc.username.dev}")
    private String usernameDev;

    /** 密码，开发环境 */
    @Value("${jdbc.password.dev}")
    private String passwordDev;

    /** 数据库连接URL，测试环境 */
    @Value("${jdbc.url.test}")
    private String urlTest;

    /** 用户名，测试环境 */
    @Value("${jdbc.username.test}")
    private String usernameTest;

    /** 密码，测试环境 */
    @Value("${jdbc.password.test}")
    private String passwordTest;

    /** 数据库连接URL，生产环境 */
    @Value("${jdbc.url.prod}")
    private String urlProd;

    /** 用户名，生产环境 */
    @Value("${jdbc.username.prod}")
    private String usernameProd;

    /** 密码，生产环境 */
    @Value("${jdbc.password.prod}")
    private String passwordProd;
    
    /** 初始化连接数 */
    @Value("${jdbc.druid.initialSize}")
    private int initialSize;
    
    /** 最大并发连接数 */
    @Value("${jdbc.druid.maxActive}")
    private int maxActive;
    
    /** 最小空闲连接数 */
    @Value("${jdbc.druid.minIdle}")
    private int minIdle;
    
    /** 获取连接时的最大等待时间，单位毫秒 */
    @Value("${jdbc.druid.maxWait}")
    private long maxWait;
    
    /** 是否使用非公平锁 */
    @Value("${jdbc.druid.useUnfairLock}")
    private boolean useUnfairLock;
    
    /** 监控统计拦截的filters */
    @Value("${jdbc.druid.filters}")
    private String filters;
    
    /** 间隔多久检测一次需要关闭的空闲连接，单位毫秒 */
    @Value("${jdbc.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    
    /** 连接在池中最小生存的时间，单位毫秒 */
    @Value("${jdbc.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    
    /** 用来检测连接是否有效的SQL查询语句 */
    @Value("${jdbc.druid.validationQuery}")
    private String validationQuery;
    
    /** 如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效 */
    @Value("${jdbc.druid.testWhileIdle}")
    private boolean testWhileIdle;
    
    /** 申请连接时执行validationQuery检测连接是否有效 */
    @Value("${jdbc.druid.testOnBorrow}")
    private boolean testOnBorrow;
    
    /** 归还连接时执行validationQuery检测连接是否有效 */
    @Value("${jdbc.druid.testOnReturn}")
    private boolean testOnReturn;
    
    /** 是否强制关闭长时间不使用的连接 */
    @Value("${jdbc.druid.removeAbandoned}")
    private boolean removeAbandoned;
    
    /** 多久之后开始关闭空闲连接，单位秒 */
    @Value("${jdbc.druid.logAbandoned}")
    private int removeAbandonedTimeout;
    
    /** 是否将关闭连接动作记录到日志 */
    @Value("${jdbc.druid.logAbandoned}")
    private boolean logAbandoned;
    
    /** 是否自动提交数据库事务 */
    @Value("${jdbc.druid.defaultAutoCommit}")
    private boolean defaultAutoCommit;
    
    /** 是否缓存preparedStatement，也就是PSCache */
    @Value("${jdbc.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    
    /**  */
    @Value("${jdbc.druid.maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;
    
    /**  */
    @Value("${jdbc.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(MAPPER_SCANNER_BASE_PACKAGE);
        return mapperScannerConfigurer;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
        sqlSessionFactoryBean.setConfiguration(myBatisConfiguration());
        sqlSessionFactoryBean.setMapperLocations(myBatisMapperLocations());
        return sqlSessionFactoryBean;
    }
    
    @Bean
    public org.apache.ibatis.session.Configuration myBatisConfiguration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // 开启全局性延迟加载
        configuration.setLazyLoadingEnabled(true);
        // 开启按需加载
        configuration.setAggressiveLazyLoading(false);
        // 调用lazyLoadAll方法触发立即加载所有延迟加载的属性
        Set<String> lazyLoadTriggerMethods = new HashSet<>(1);
        lazyLoadTriggerMethods.add("lazyLoadAll");
        configuration.setLazyLoadTriggerMethods(lazyLoadTriggerMethods);
        // 一级缓存作用域为SESSION
        configuration.setLocalCacheScope(LocalCacheScope.SESSION);
        // 开启二级缓存
        configuration.setCacheEnabled(true);
        // 新增记录时返回数据库自动生成的主键ID
        configuration.setUseGeneratedKeys(true);
        // 数据表字段名下划线转驼峰
        configuration.setMapUnderscoreToCamelCase(true);
        // 使用SLF4J打印日志
        configuration.setLogPrefix("MyBatis-");
        configuration.setLogImpl(StdOutImpl.class);
        return configuration;
    }
    
    @Bean
    public Resource[] myBatisMapperLocations() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        return resolver.getResources(MYBATIS_MAPPER_LOCATION);
    }
    
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean
    public JdbcOperations jdbcOperations(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 开发环境数据源配置
     * 
     * @return DataSource
     * @author caizhukui
     * @throws SQLException 
     * @date 2018年4月10日
     */
    @Bean(destroyMethod = "close")
    @Profile(ProfileConstant.DEV)
    public DataSource devDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://ustvseries.mysql.rds.aliyuncs.com:3838/rrmeiju?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("1qaz@WSX");
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(urlDev);
//        dataSource.setUsername(usernameDev);
//        dataSource.setPassword(passwordDev);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMaxActive(maxActive);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setUseUnfairLock(useUnfairLock);
//        dataSource.setFilters(filters);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        dataSource.setValidationQuery(validationQuery);
//        dataSource.setTestWhileIdle(testWhileIdle);
//        dataSource.setTestOnBorrow(testOnBorrow);
//        dataSource.setTestOnReturn(testOnReturn);
//        dataSource.setRemoveAbandoned(removeAbandoned);
//        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
//        dataSource.setLogAbandoned(logAbandoned);
//        dataSource.setDefaultAutoCommit(defaultAutoCommit);
//        dataSource.setPoolPreparedStatements(poolPreparedStatements);
//        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return dataSource;
    }

    /**
     * 测试环境数据源配置
     * 
     * @return DataSource
     * @author caizhukui
     * @throws SQLException 
     * @date 2018年4月10日
     */
    @Bean(destroyMethod = "close")
    @Profile(ProfileConstant.TEST)
    public DataSource testDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(urlTest);
        dataSource.setUsername(usernameTest);
        dataSource.setPassword(passwordTest);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setUseUnfairLock(useUnfairLock);
        dataSource.setFilters(filters);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setRemoveAbandoned(removeAbandoned);
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        dataSource.setLogAbandoned(logAbandoned);
        dataSource.setDefaultAutoCommit(defaultAutoCommit);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return dataSource;
    }

    /**
     * 生产环境数据源配置
     * 
     * @return DataSource
     * @author caizhukui
     * @throws SQLException 
     * @date 2018年4月10日
     */
    @Bean(destroyMethod = "close")
    @Profile(ProfileConstant.PROD)
    public DataSource prodDataSource() throws SQLException {
        System.out.println(driverClassName);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://ustvseries.mysql.rds.aliyuncs.com:3838/rrmeiju?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("1qaz@WSX");
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(urlProd);
//        dataSource.setUsername(usernameProd);
//        dataSource.setPassword(passwordProd);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMaxActive(maxActive);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setUseUnfairLock(useUnfairLock);
//        dataSource.setFilters(filters);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        dataSource.setValidationQuery(validationQuery);
//        dataSource.setTestWhileIdle(testWhileIdle);
//        dataSource.setTestOnBorrow(testOnBorrow);
//        dataSource.setTestOnReturn(testOnReturn);
//        dataSource.setRemoveAbandoned(removeAbandoned);
//        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
//        dataSource.setLogAbandoned(logAbandoned);
//        dataSource.setDefaultAutoCommit(defaultAutoCommit);
//        dataSource.setPoolPreparedStatements(poolPreparedStatements);
//        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return dataSource;
    }

}
