package com.sist.web.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.RequiredArgsConstructor;
import java.util.*;
import com.sist.web.vo.*;

import jakarta.servlet.http.HttpServletRequest;

import com.sist.web.service.*;
@Aspect
@Component
@RequiredArgsConstructor
public class FooterAOP {
	private final BizService bservice;
	
	@After("execution(* com.sist.web.controller.*Controller.*(..))")
	public void after()
	{
		Map map=new HashMap();
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<BizVO> blist=bservice.viewTop10Data();
		request.setAttribute("blist", blist);
	}
}
