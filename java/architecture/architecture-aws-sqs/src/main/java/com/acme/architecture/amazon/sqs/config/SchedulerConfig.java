package com.acme.architecture.amazon.sqs.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

	private static final Logger LOG = LoggerFactory.getLogger(SchedulerConfig.class);
	
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    	LOG.debug("[CONFIGURATION] Configuring Scheduler Tasks ...");
        
    	ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        taskScheduler.initialize();
        taskScheduler.setThreadNamePrefix("ScheduledExecutor-");

        taskRegistrar.setTaskScheduler(taskScheduler);
    }

}
