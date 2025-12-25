package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BizController {
	private final BizService bservice;
	private final ShoesService sservice;
	private final MusicService mservice;
	
	@GetMapping("/biz/list")
	public String business_list(@RequestParam(name="page",required = false)String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage-1)*12;
		List<BizVO> list=bservice.businessListData(start);
		int totalpage=bservice.businessTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("blist", bservice.viewTop10Data());
		model.addAttribute("slist", sservice.shoesTop10Data());
		model.addAttribute("mlist", mservice.musicTop10Data());

		model.addAttribute("main_html", "biz/list");
		return "main/main";
	}
	
	@GetMapping("/biz/b_type")
	public String biz_type(@RequestParam(name="page",required = false) String page,Model model,@RequestParam("b_type") String b_type)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage-1)*12;
		
		List<BizVO> list=bservice.typeListData(b_type, start);
		int totalpage=bservice.typeTotalPage(b_type);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("b_type", b_type);
		
		model.addAttribute("blist", bservice.viewTop10Data());
		model.addAttribute("slist", sservice.shoesTop10Data());
		model.addAttribute("mlist", mservice.musicTop10Data());

		model.addAttribute("main_html", "biz/type_list");
		return "main/main";
	}
	
	@GetMapping("/biz/detail")
	public String biz_detail(@RequestParam("b_id") String b_id,Model model)
	{
		BizVO vo=bservice.contentDetailData(b_id);
		model.addAttribute("vo", vo);
		model.addAttribute("main_html", "biz/detail");
		return "main/main";
	}
}
