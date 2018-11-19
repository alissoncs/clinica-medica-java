package com.vine.service;

import java.util.List;

public interface BaseService<T> {
	public T fetchById(Long id);
	public List<T> fetchAll();
	public void delete(T i) throws Exception;
	public T create(T i) throws Exception;
	public T update(T i) throws Exception;
}
