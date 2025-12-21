package com.sist.web.service;
import org.springframework.stereotype.Service;
import com.sist.web.mapper.MusicMapper;
import com.sist.web.vo.MusicVO;

import lombok.RequiredArgsConstructor;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService{
	private final MusicMapper mapper;

	@Override
	public List<MusicVO> musicTop9Data() {
		// TODO Auto-generated method stub
		return mapper.musicTop9Data();
	}

	@Override
	public List<MusicVO> musicTop200List(int start) {
		// TODO Auto-generated method stub
		return mapper.musicTop200List(start);
	}

	@Override
	public int musicTop200TotalPage() {
		// TODO Auto-generated method stub
		return mapper.musicTop200TotalPage();
	}
	
	@Override
	public int musicTotalPage() {
		// TODO Auto-generated method stub
		return mapper.musicTotalPage();
	}

	@Override
	public MusicVO musicDetailData(int no) {
		// TODO Auto-generated method stub
		return mapper.musicDetailData(no);
	}




	

}
