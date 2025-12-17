package com.sist.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final BizService bservice;
	
	@GetMapping("/")
	public String main_page(Model model)
	{
		Map map=new HashMap();
		map.put("table_name", "board");
		List<BizVO> blist=bservice.viewTop10Data();
		
		model.addAttribute("blist", blist);
		model.addAttribute("main_html", "main/home");
		return "main/main";
	}
}
