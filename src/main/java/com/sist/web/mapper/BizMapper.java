package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Repository
@Mapper
public interface BizMapper {
	// 비즈니스 리스트
	@Select("SELECT b_id, b_filter,b_type,b_title,b_thumbnail "
			+ "FROM board "
			+ "ORDER BY b_id ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<BizVO> businessListData(int start);
	// 비즈니스 총 페이지
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM board")
	public int businessTotalPage();
	// 컨텐츠 Top10(푸터)
	@Select("SELECT b_id,b_title,b_view_count,rownum "
			+ "FROM (SELECT b_id,b_title,b_view_count "
			+ "FROM board ORDER BY b_view_count DESC) "
			+ "WHERE rownum<=10")
	public List<BizVO> viewTop10Data();
	
	// 타입 리스트
	@Select("SELECT b_id, b_thumbnail,b_title,b_filter,b_type "
			+ "FROM board "
			+ "WHERE b_type=#{b_type} "
			+ "ORDER BY b_id DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<BizVO> typeListData(@Param("b_type") String b_type,@Param("start")int start);
	// 타입 총 페이지
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM board "
			+ "WHERE b_type=#{b_type}")
	public int typeTotalPage(@Param("b_type") String b_type);
	
	// 상세보기
	@Select("SELECT * FROM board "
			+ "WHERE b_id=#{b_id}")
	public BizVO contentDetailData(String b_id);
}
