package com.sist.web.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.ShoesService;
import com.sist.web.vo.ShoesVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShoesController {
	private final ShoesService service;
	
	@GetMapping("/shoes/list")
	public String shoes_list(@RequestParam(name="page",required = false) String page,Model model)
	{
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage-1)*12;
		List<ShoesVO> list=service.shoesListData(start);
		int totalpage=service.shoesTotalPage();
		
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("main_html", "shoes/list");
		return "main/main";
	}
	
	@GetMapping("/shoes/brand")
	public String shose_brand(@RequestParam(name="brand")String brand,@RequestParam(name="page",required = false)String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage-1)*12;
		List<ShoesVO> list=service.brandListData(brand, start);
		int totalpage=service.brandTotalPage(brand);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("brand", brand);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html", "shoes/brand_list");
		return "main/main";
	}
	
	@GetMapping("/shoes/detail")
	public String shoes_detail(@RequestParam("goods_id") int goods_id,Model model,HttpSession session)
	{
		ShoesVO vo=service.shoesDetailData(goods_id);
		String id=(String)session.getAttribute("id");
		if(id==null)
		{
			model.addAttribute("sessionId", "");
		}
		else
		{
			model.addAttribute("sessionId", id);
		}
		model.addAttribute("vo", vo);
		model.addAttribute("main_html", "shoes/detail");
		return "main/main";
	}
	
}
