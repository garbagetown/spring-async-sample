package com.example.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AsyncController {

	private final AsyncService asyncService;

	@GetMapping(path = "p", params = "sync")
	public Person sync() {
		log.info("controller start");
		Person p = asyncService.sync();
		log.info("controller end");
		return p;
	}

	@GetMapping(path = "p", params = "async")
	public DeferredResult<Person> async() {
		log.info("controller start");
		DeferredResult<Person> result = new DeferredResult<>();
		asyncService.async(result);
		log.info("controller end");
		return result;
	}
}
