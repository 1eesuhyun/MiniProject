package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Repository
@Mapper
public interface BizMapper {
	@Select("SELECT b_id, b_filter,b_type,b_title,b_thumbnail "
			+ "FROM board "
			+ "ORDER BY b_id ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<BizVO> businessListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM board")
	public int businessTotalPage();
	
	@Select("SELECT b_id,b_title,b_view_count,rownum "
			+ "FROM (SELECT b_id,b_title,b_view_count "
			+ "FROM board ORDER BY b_view_count DESC) "
			+ "WHERE rownum<=10")
	public List<BizVO> viewTop10Data(Map map);
}
