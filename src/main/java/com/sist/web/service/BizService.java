package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sist.web.vo.*;

public interface BizService {
	public List<BizVO> businessListData(int start);
	public int businessTotalPage();
	public List<BizVO> viewTop10Data();
	public List<BizVO> typeListData(String b_type,int start);
	public int typeTotalPage(String b_type);
	public BizVO contentDetailData(String b_id);
}
