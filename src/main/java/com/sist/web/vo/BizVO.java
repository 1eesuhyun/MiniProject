package com.sist.web.vo;

import java.util.Date;

import lombok.Data;
@Data
public class BizVO {
	private int u_s_id,b_view_count;
	private String b_id,b_filter,b_title,b_content,b_thumbnail,b_prod_on_off,b_type;
	private Date b_createdAt,b_updatedAt;
}
