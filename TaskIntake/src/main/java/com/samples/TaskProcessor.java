package com.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
//Bind cloud stream and rabbit queue
public class TaskProcessor {

	@Autowired
	private Source source;  //ref to rabbit queue

	public void publishRequest(String payload) {

		//maven://[groupid]:[artifactid]:jar:[version]
		String url = "maven://com.samples.boot:Task:jar:0.0.1";

		List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));

		TaskLaunchRequest request = new TaskLaunchRequest(url, input, null, null);


		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
		
		
		this.source.output().send(message);
	}

}
