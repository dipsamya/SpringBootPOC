package com.samtech.HelloWorld.controller;

import java.util.Map;
import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.samtech.HelloWorld.beans.Persion;

@RestController
@RequestMapping("/hello")
public class HelloWorld {
	Map<Integer,Persion> dataamp=null;
	
	public HelloWorld() {
		dataamp =new ConcurrentHashMap<>();
		Persion poulomi=new Persion("poulomi", 24);
		poulomi.setId(poulomi.hashCode());
		dataamp.put(poulomi.hashCode(), poulomi);
		System,out.println("id added..");
		System.out.println("hashcode of poulomi ="+poulomi.getId());
	}

	@RequestMapping(method=RequestMethod.GET,value="/hello")
	public String hello() {
		return "well come to my application";
	}
	
	@PostMapping("/add-persion")
	@RequestWrapper(className= "Persion")
	public String addPersion(@RequestBody Persion persion) {
		System.out.println("persion name:"+persion.getName());
		persion.setId(persion.hashCode());
		dataamp.put(persion.getId(), persion);
		return persion.hashCode()+" remember this id";
	}
	@GetMapping("/get-persion")
	public Persion getPersion(@RequestParam("id")int id) {
		return dataamp.get(id);
	}
}
