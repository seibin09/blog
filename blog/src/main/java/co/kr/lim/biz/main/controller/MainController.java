package co.kr.lim.biz.main.controller;

import org.springframework.lang.UsesJava7;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
  * author : YoungBoss
  * since : 2019. 1. 29.
  */
@Controller
@Slf4j
public class MainController {

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		
		return "index.html";
	}
}
