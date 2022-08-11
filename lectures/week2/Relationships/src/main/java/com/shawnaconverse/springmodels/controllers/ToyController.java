package com.shawnaconverse.springmodels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shawnaconverse.springmodels.services.ToyService;

@Controller
@RequestMapping("/toys")
public class ToyController {
	@Autowired
	private ToyService toyServ;
	
	
}
