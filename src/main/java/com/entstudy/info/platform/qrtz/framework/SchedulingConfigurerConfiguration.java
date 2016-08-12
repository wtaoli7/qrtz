package com.entstudy.info.platform.qrtz.framework;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/** 
 * @ClassName: SchedulingConfigurerConfiguration 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liwt
 * @date 2016年7月29日 下午3:48:48 
 *  
 */
@Configuration
public class SchedulingConfigurerConfiguration implements SchedulingConfigurer {

	/* (non-Javadoc)
	 * @see org.springframework.scheduling.annotation.SchedulingConfigurer#configureTasks(org.springframework.scheduling.config.ScheduledTaskRegistrar)
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        taskScheduler.initialize();
        taskRegistrar.setTaskScheduler(taskScheduler);
	}

}
