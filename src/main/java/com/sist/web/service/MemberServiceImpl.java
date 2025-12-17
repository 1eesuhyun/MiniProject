package com.sist.web.service;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.MemberMapper;
import com.sist.web.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	private final MemberMapper mapper;

	@Override
	public MemberVO memberLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		MemberVO vo=new MemberVO();
		int count=mapper.memberIdCount(id);
		if(count==0)
		{
			vo.setMsg("NOID");
		}
		else
		{
			MemberVO dbVo=mapper.memberInfoData(id);
			if(pwd.equals(dbVo.getPwd()))
			{
				vo=dbVo;
				vo.setMsg("OK");
			}
			else
			{
				vo.setMsg("NOPWD");
			}
		}
		return null;
	}
}
