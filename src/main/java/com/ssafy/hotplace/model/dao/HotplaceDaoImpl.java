package com.ssafy.hotplace.model.dao;

import com.ssafy.util.DBUtil;

public class HotplaceDaoImpl implements HotplaceDao {
	private static HotplaceDao instance = new HotplaceDaoImpl();
	private DBUtil util;
	
	private HotplaceDaoImpl() {
		util = DBUtil.getInstance();
	}
	
	public static HotplaceDao getInstance() {
		return instance;
	}

}
