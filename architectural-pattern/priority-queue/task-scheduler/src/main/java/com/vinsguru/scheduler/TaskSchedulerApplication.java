package com.vinsguru.scheduler;

import com.vinsguru.model.Task;
import org.redisson.api.RPriorityBlockingQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class TaskSchedulerApplication {

	@Autowired
	private RedissonClient redissonClient;

	public static void main(String[] args) {
		SpringApplication.run(TaskSchedulerApplication.class, args);
	}

	@Bean
	public RPriorityBlockingQueue<Task> getQueue(){
		return this.redissonClient.getPriorityBlockingQueue("task");
	}

}
