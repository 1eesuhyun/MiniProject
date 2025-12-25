package com.sist.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.BizService;
import com.sist.web.service.MusicService;
import com.sist.web.service.ShoesService;

import lombok.RequiredArgsConstructor;
import java.util.*;
import com.sist.web.vo.*;

@Controller
@RequiredArgsConstructor
public class MusicController {
	private final MusicService mservice;
	private final BizService bservice;
	private final ShoesService sservice;
	
	
	@GetMapping("/music/Top200_list")
	public String music_list(@RequestParam(name="page",required = false)String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage-1)*12;
		List<MusicVO> list=mservice.musicTop200List(start);
		int totalpage=mservice.musicTop200TotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		model.addAttribute("curpage", curpage);
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalpage", totalpage);
		
		model.addAttribute("blist", bservice.viewTop10Data());
		model.addAttribute("slist", sservice.shoesTop10Data());
		model.addAttribute("mlist", mservice.musicTop10Data());
		model.addAttribute("main_html", "music/Top200_list");
		return "main/main";
	}
}
