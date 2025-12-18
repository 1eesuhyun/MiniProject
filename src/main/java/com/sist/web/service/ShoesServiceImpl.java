package com.sist.web.service;

import java.util.List;

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
		mapper.shoesBookMark(goods_id);
		return mapper.shoesDetailData(goods_id);
	}

	@Override
	public List<ShoesVO> nikebrand() {
		// TODO Auto-generated method stub
		return mapper.nikebrand();
	}

	@Override
	public List<ShoesVO> adidasbrand() {
		// TODO Auto-generated method stub
		return mapper.adidasbrand();
	}

	@Override
	public List<ShoesVO> asicsbrand() {
		// TODO Auto-generated method stub
		return mapper.asicsbrand();
	}

	@Override
	public List<ShoesVO> mihara_Yasuhirobrand() {
		// TODO Auto-generated method stub
		return mapper.mihara_Yasuhirobrand();
	}

}
