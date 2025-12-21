package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.MusicVO;

public interface MusicService {
	public List<MusicVO> musicTop9Data();
	public List<MusicVO> musicTop200List(int start);
	public int musicTop200TotalPage();
	
	public int musicTotalPage();
	public MusicVO musicDetailData(int no);
}
