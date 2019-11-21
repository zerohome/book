package com.zero.book.springboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "Hello World";
	}

	/**
	 * <p>ApplicationRunner#run(ApplicationArguments) 会在应用启动后回调 .</p>
	 * <p>时间 : 2019年11月21日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @see Application#onWebServerReady(WebServerInitializedEvent)
	 * @return
	 */
	@Bean
	@Deprecated
	public ApplicationRunner runner() {
		return args -> {};
	}
	
	@EventListener(WebServerInitializedEvent.class)
	public void onWebServerReady(WebServerInitializedEvent initEvent) {
		initEvent.getWebServer();
	}
}
