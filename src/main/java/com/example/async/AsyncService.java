package com.example.async;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncService {

	public Person sync() {
		log.info("service start");
		sleep(5);
		Person p = new Person("AAA", 10);
		log.info("service end");
		return p;
	}

	@Async
	public void async(DeferredResult<Person> result) {
		log.info("service start");
		sleep(5);
		result.setResult(new Person("AAA", 10));
		log.info("service end");
	}

	private void sleep(int i) {
		try {
			TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
	}
}
