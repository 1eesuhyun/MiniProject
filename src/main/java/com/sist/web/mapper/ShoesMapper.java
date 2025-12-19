package com.sist.web.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
@Repository
public interface ShoesMapper {
	@Select("SELECT goods_id,img,name_kor,brand "
			+ "FROM shoes ORDER BY goods_id DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ShoesVO> shoesListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM shoes")
	public int shoesTotalPage();
	
	@Select("SELECT * FROM shoes "
			+ "WHERE goods_id=#{goods_id}")
	public ShoesVO shoesDetailData(int goods_id);
	
	@Update("UPDATE shoes SET "
			+ "hit=hit+1 "
			+ "WHERE goods_id=#{goods_id}")
	public void shoesHitIncrement(int goods);
	
	@Select("SELECT goods_id,img,name_kor "
			+ "FROM shoes "
			+ "WHERE brand=#{brand} "
			+ "ORDER BY goods_id DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ShoesVO> brandListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM shoes "
			+ "WHERE brand=#{brand}")
	public int brandTotalPage(Map map);
	
}
