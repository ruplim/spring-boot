package com.samples;

import java.io.FileOutputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			//parameters stationid, license plate, timestamp
			if( null != args) {
				
				
				FileOutputStream fout = new FileOutputStream("c:/Ruplim/cloud.txt");
				fout.write("Hello World from Cloud".getBytes());
				fout.flush();
				fout.close();
				
				String stationId    = args[1];
				String licensePlate = args[2];
				String timestamp    = args[3];
				
				System.out.println(" +++ StationId : " + stationId + "; licensePlate :" + licensePlate + " ; timestamp :" + timestamp);
				
			}
		}		
	}
}
