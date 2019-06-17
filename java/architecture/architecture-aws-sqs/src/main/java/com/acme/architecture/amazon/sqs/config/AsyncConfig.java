package com.acme.architecture.amazon.sqs.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
	
	private static final Logger LOG = LoggerFactory.getLogger(AsyncConfig.class);
	
	@PostConstruct
    public void init() {
		LOG.debug("[CONFIGURATION] Configuring Async ...");
    }

    @Bean("asyncExecutor")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setThreadNamePrefix("AsyncExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> LoggerFactory.getLogger("Async").error("Async error", throwable); // ?
    }

}
