package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.BizMapper;
import com.sist.web.vo.BizVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BizServicimpl implements BizService{
	private final BizMapper mapper;

	@Override
	public List<BizVO> businessListData(int start) {
		// TODO Auto-generated method stub
		return mapper.businessListData(start);
	}

	@Override
	public int businessTotalPage() {
		// TODO Auto-generated method stub
		return mapper.businessTotalPage();
	}

	@Override
	public List<BizVO> viewTop10Data() {
		// TODO Auto-generated method stub
		return mapper.viewTop10Data();
	}

	
}
