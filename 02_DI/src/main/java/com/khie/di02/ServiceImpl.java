package com.khie.di02;

public class ServiceImpl {
	
	private DAO dao;
	
	public ServiceImpl() { }

	public ServiceImpl(DAO dao) {
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	// 비스니스 로직
	public void biz() {
		this.dao.add();
	}
	
	
	
	
}
