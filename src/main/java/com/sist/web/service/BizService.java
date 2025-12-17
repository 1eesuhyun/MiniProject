package com.sist.web.service;

import java.util.List;
import java.util.Map;

import com.sist.web.vo.*;

public interface BizService {
	public List<BizVO> businessListData(int start);
	public int businessTotalPage();
	public List<BizVO> viewTop10Data();
}
