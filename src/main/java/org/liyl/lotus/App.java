package org.liyl.lotus;

import org.liyl.lotus.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author 李毅霖.
 * @Date 2018/9/14.
 * @description:.
 * @modified by
 */
@SpringBootApplication
public class App {

	@Bean
	public CorsFilter corsFilter(){
		return new CorsFilter();
	}

	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}
}
