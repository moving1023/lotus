package org.liyl.lotus;

import org.liyl.lotus.filter.AuthFilter;
import org.liyl.lotus.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

/**
 * @Author 李毅霖.
 * @Date 2018/9/14.
 * @description:.
 * @modified by
 */
@SpringBootApplication
public class App {

	@Bean
	public Filter corsFilter(){
		return new CorsFilter();
	}

	@Bean
	public Filter authFilter() {
		return new AuthFilter();
	}

	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}
}
