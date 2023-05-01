package com.ssafy.hotplace.model.service;

import com.ssafy.hotplace.model.dao.HotplaceDao;
import com.ssafy.hotplace.model.dao.HotplaceDaoImpl;

public class HotplaceServiceImpl implements HotplaceService {
	private static HotplaceService instance = new HotplaceServiceImpl();
	private HotplaceDao hotplaceDao;
	
	private HotplaceServiceImpl() {
		hotplaceDao = HotplaceDaoImpl.getInstance();
	}
	
	public static HotplaceService getInstance() {
		return instance;
	}

}
