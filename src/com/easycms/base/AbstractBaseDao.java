package com.easycms.base;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import com.easycms.dao.Idao;
import com.easycms.common.GetEntityClassUtil;
import com.easycms.common.Pager;

public abstract class AbstractBaseDao<T,PK extends Serializable> implements BaseDao<T,PK>{
	Class entityClass = GetEntityClassUtil.getEntityClass(getClass());
	@Resource
	private Idao<T, Serializable> idao;
	@Override
	public void save(T entity) {
		idao.save(entity);
	}
	@Override
	public void delete(PK pk) {
		idao.delete(entityClass,pk);
	}
	@Override
	public void update(T entity) {
		idao.update(entity);
	}
	@Override
	public T findById(PK pk) {
		return idao.findById(entityClass, pk);
	}
	@Override
	public List<T> findAll() {
		return idao.findAll(entityClass);
	}
	@Override
	public Pager<T> findByPage(int showPages, int pageSize) {
		return idao.findByPage(entityClass, showPages, pageSize);
	}
	
	public T findByParam(Map<String, Object> maps,String operate) {
		return idao.findByParam(entityClass, maps, operate);
	}
}
