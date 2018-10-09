package com.bqf.spring.springretry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bqf.spring.springretry.RemoteService;

@RestController
public class TestController {
	
	@Autowired
	private RemoteService remoteService;
	
	@RequestMapping("/show")
	public String show(){
		long start = System.currentTimeMillis();
		System.out.println("in..." + start);
		try {
			remoteService.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("cost..." + (System.currentTimeMillis()- start)/1000);
		
		return "Hello World";		
	}
}
