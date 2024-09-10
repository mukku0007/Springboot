package com.restapi.scheduler;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyScheduler {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(MyScheduler.class);
	
	// 1. Type
	@Scheduled(cron = "1 * * * * ?")
	public void scheduler1() {
		logger.info("CRON Schduler: ");
	}
	
	// 2. Type
//	@Scheduled(fixedRate = 1000)
//	public void schduler2() {
//		logger.info("Fixed Rate: ");
//	}
	
	// 3. Type
//	@Scheduled(fixedDelay = 1000, initialDelay = 2000)
//	public void schduler3() {
//		logger.info("Fixed Delay: ");
//	}
	
	

	/*
			* * * * * *
			│ │ │ │ │ │
			│ │ │ │ │ └─ Day of the week (0-7) (Sunday=0 or 7)
			│ │ │ │ └─── Month (1-12)
			│ │ │ └───── Day of the month (1-31)
			│ │ └─────── Hour (0-23)
			│ └───────── Minute (0-59)
			└─────────── Second (0-59) [optional in some systems]
	
			
			
			Example Cron Expressions:-
			Every minute: * * * * *
			At 2:30 PM every day: 30 14 * * *
			At 3:15 AM on the 1st of every month: 15 3 1 * *
			Every Monday at 8:00 AM: 0 8 * * 1
			Every 5 minutes: * 5 * * * *

	
	 */
	
}
