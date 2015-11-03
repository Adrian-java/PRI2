package com.eclinic.web.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Component("DocumentController")
@RequestMapping("/documents")
public class DocumentController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@ResponseBody
	public String hello() {
		return "Hello world!";
	}
	
}
