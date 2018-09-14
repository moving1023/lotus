package org.liyl.lotus.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author 李毅霖.
 * @Date 2018/9/14.
 * @description:.
 * @modified by
 */
@Component
public class CommonTask {

	@Scheduled(cron = "${job.cron.reload-menu}")
	public void reload() {
		//System.out.println("测试");
	}

}
