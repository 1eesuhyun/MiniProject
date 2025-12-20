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

	@Override
	public List<BizVO> typeListData(String b_type, int start) {
		// TODO Auto-generated method stub
		return mapper.typeListData(b_type,start);
	}

	@Override
	public int typeTotalPage(String b_type) {
		// TODO Auto-generated method stub
		return mapper.typeTotalPage(b_type);
	}

	@Override
	public BizVO contentDetailData(String b_id) {
		// TODO Auto-generated method stub
		return mapper.contentDetailData(b_id);
	}

	
}
