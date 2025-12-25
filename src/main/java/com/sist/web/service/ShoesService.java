package com.sist.web.service;

import java.util.*;
import com.sist.web.vo.*;

public interface ShoesService {
	public List<ShoesVO> shoesListData(int start);
	public int shoesTotalPage();
	public ShoesVO shoesDetailData(int goods_id);
	public List<ShoesVO> brandListData(String brand,int start);
	public int brandTotalPage(String brand);
	public List<ShoesVO> shoesTop10Data();
}
