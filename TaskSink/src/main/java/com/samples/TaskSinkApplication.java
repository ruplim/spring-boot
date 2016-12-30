package com.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
// this says this sink can take a task launcher task request and kick the task up.
public class TaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskSinkApplication.class, args);
	}
}
