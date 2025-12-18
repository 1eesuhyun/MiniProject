package com.sist.web.service;

import java.util.List;


import com.sist.web.vo.ShoesVO;

public interface ShoesService {
	public List<ShoesVO> shoesListData(int start);
	public int shoesTotalPage();
	public ShoesVO shoesDetailData(int goods_id);
	public List<ShoesVO> nikebrand();
	public List<ShoesVO> adidasbrand();
	public List<ShoesVO> asicsbrand();
	public List<ShoesVO> mihara_Yasuhirobrand();
}
