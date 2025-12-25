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
	private final ShoesService sservice;
	private final MusicService mservice;
	private final CafeService cservice;
	
	@GetMapping("/")
	public String main_page(Model model)
	{
		Map map=new HashMap();
		map.put("table_name", "board");
		List<BizVO> blist=bservice.viewTop10Data();
		
		map.put("table_name", "shoes");
		List<ShoesVO> slist=sservice.shoesTop10Data();
		
		map.put("table_name", "music");
		List<MusicVO> mlist=mservice.musicTop10Data();
		
		map.put("table_name", "cafe");
		List<CafeVO> clist=cservice.cafeList9Data();
		
		model.addAttribute("blist", blist);
		model.addAttribute("slist", slist);
		model.addAttribute("mlist", mlist);
		model.addAttribute("clist", clist);
		
		model.addAttribute("main_html", "main/home");
		return "main/main";
	}
}
