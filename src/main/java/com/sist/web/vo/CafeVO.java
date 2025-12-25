package com.sist.web.vo;

import lombok.Data;

@Data
public class CafeVO {
	private int id,calories_kcal,caffeine_mg;
	private String category_name,menu_name,image_url;
}
