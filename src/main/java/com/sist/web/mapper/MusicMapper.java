package com.sist.web.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Repository
@Mapper
public interface MusicMapper {
	@Select("SELECT no,cno,rank,title,singer,poster,rownum "
			+ "FROM (SELECT no,cno,rank,title,singer,poster "
			+ "FROM genie_music ORDER BY rank ASC) "
			+ "WHRER rownum<=9")
	public List<MusicVO> musicTop9Data();
	
	@Select("SELECT no,cno,title,singer,poster "
			+ "FROM(SELECT no,cno,title,singer,poster "
			+ "FROM genie_music "
			+ "ORDER BY no ASC "
			+ "FETCH FIRST 200 ROWS ONLY) "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<MusicVO> musicTop200List(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM(SELECT no FROM genie_music) "
			+ "WHERE rownum <=200")
	public int musicTop200TotalPage();
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM genie_music")
	public int musicTotalPage();
	
	@Select("SELECT * FROM genie_music "
			+ "WHERE no=#{no}")
	public MusicVO musicDetailData(int no);
	
	@Select("SELECT no,cno,rank,title,rownum "
			+ "FROM(SELECT no,cno,rank,title "
			+ "FROM genie_music ORDER BY rank ASC) "
			+ "WHERE rownum<=10")
	public List<MusicVO> musicTop10Data();
}
