package cn.springmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String main(){
		return "pc/index";
	}
	
	@RequestMapping(value = "/mobile/index.do", method = RequestMethod.GET)
	public String mobile(){
		return "mobile/index";
	}
}
