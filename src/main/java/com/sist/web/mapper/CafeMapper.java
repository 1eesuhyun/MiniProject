package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Repository
@Mapper
public interface CafeMapper {
	@Select("SELECT id,menu_name,image_url,calories_kcal,caffeine_mg,rownum "
			+ "FROM(SELECT id,menu_name,image_url,calories_kcal,caffeine_mg "
			+ "FROM cafe ORDER BY id ASC) "
			+ "WHERE rownum<=9")
	public List<CafeVO> cafeList9Data();
}
