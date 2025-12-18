package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.ShoesMapper;
import com.sist.web.vo.ShoesVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShoesServiceImpl implements ShoesService{
	private final ShoesMapper mapper;

	@Override
	public List<ShoesVO> shoesListData(int start) {
		// TODO Auto-generated method stub
		return mapper.shoesListData(start);
	}

	@Override
	public int shoesTotalPage() {
		// TODO Auto-generated method stub
		return mapper.shoesTotalPage();
	}

	@Override
	public ShoesVO shoesDetailData(int goods_id) {
		// TODO Auto-generated method stub
		mapper.shoesHitIncrement(goods_id);
		return mapper.shoesDetailData(goods_id);
	}

	@Override
	public List<ShoesVO> brandListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.brandListData(map);
	}

	@Override
	public int brandTotalPage(Map map) {
		// TODO Auto-generated method stub
		return mapper.brandTotalPage(map);
	}

}
