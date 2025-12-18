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
	@Select("SELECT goods_id,brand,img,name_kor,rownum "
			+ "FROM(SELECT goods_id,rt_price,brand,img,name_kor,type,color "
			+ "FROM shoes ORDER BY goods_id DESC) "
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
	public void shoesBookMark(int goods);
	
	@Select("SELECT * FROM shoes "
			+ "WHERE brand = 'Nike' "
			+ "FROM shoes ORDER BY goods_id DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ShoesVO> nikebrand();
	
	@Select("SELECT * FROM shoes "
			+ "WHERE brand = 'Adidas' "
			+ "FROM shoes ORDER BY goods_id DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ShoesVO> adidasbrand();
	
	@Select("SELECT * FROM shoes "
			+ "WHERE brand = 'Asics' "
			+ "FROM shoes ORDER BY goods_id DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ShoesVO> asicsbrand();
	
	@Select("SELECT * FROM shoes "
			+ "WHERE brand = 'Mihara Yasuhiro' "
			+ "FROM shoes ORDER BY goods_id DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<ShoesVO> mihara_Yasuhirobrand();
}
