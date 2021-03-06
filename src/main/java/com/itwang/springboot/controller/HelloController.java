package com.itwang.springboot.controller;

import java.util.Arrays;
import java.util.Map;

import com.itwang.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(@RequestParam("user") String user)
	{
		if("aaa".equals(user)){
			throw new UserNotExistException();
		}
		return "hello world";
	}
	@RequestMapping("/success")
	public String success(Map<String,Object> map) {
		map.put("hello", "<h1>你好</h1>");
		map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
		//classpath:/templates/success.html
		return "success";
	}

}
