package com.sist.web.service;

import java.util.*;
import com.sist.web.vo.*;

public interface ShoesService {
	public List<ShoesVO> shoesListData(int start);
	public int shoesTotalPage();
	public ShoesVO shoesDetailData(int goods_id);
	public List<ShoesVO> brandListData(Map map);
	public int brandTotalPage(Map map);
}
