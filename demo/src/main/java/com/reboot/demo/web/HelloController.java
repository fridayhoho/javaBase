package com.reboot.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Function:  TODO
 * Date:      2019-06-04 21:48
 * author     daguang
 * version    V1.0
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String funcIndex(){
		return "Hello Boot";
	}
}
