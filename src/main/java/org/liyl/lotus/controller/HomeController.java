package org.liyl.lotus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 李毅霖.
 * @Date 2018/9/14.
 * @description:.
 * @modified by
 */
@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello lotus";
	}

}
