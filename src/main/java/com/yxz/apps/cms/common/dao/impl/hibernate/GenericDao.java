package com.yxz.apps.cms.common.dao.impl.hibernate;

import java.io.Serializable;
import java.util.*;

/**
 * <p/> 使用泛型作为DAO的通用接口 这里没有提供按名称精确查找,和模糊查找 上述两个方法应该由各自的具体接口去定义 <p/>
 * 
 * @author chenming
 * @param <T> :
 *            持久化的实体Bean
 * @param <K> :
 *            实体Bean的id
 */
public interface GenericDao<T, K extends Serializable> {
	/**
	 * 保存实体
	 * 
	 * @param entity :
	 *            实体
	 * @return 保存后得到的id
	 */
	public K save(T entity);

	/**
	 * 在查找所有记录的时候,使用提供查询语句,查询匹配的记录,否则将使用默认的查询语句查询数据的所有记录.
	 * 
	 * @param hql :
	 *            自定义的HQL语句
	 */
	public void setHql(String hql);

	/**
	 * 恢复hql的原始值
	 */
	public void reSetHql();
	/**
	 * 
	 * @return 自定义的HQL语句
	 */
	public String getHql();
	/**
	 * 设置hql与参数列表
	 * @param hql
	 * @param params
	 */
	public void setHql(String hql, List params);

	/**
	 * <p>
	 * 删除实体
	 * </p>
	 * 
	 * @param entity :
	 *            实体
	 */
	public void remove(T entity);

	/**
	 * <p>
	 * 删除实体集合
	 * </p>
	 * 
	 * @param entities :
	 *            实体
	 */
	public void removeAll(Collection<T> entities);

	/**
	 * <p>
	 * 修改实体
	 * </p>
	 * 
	 * @param entity :
	 *            实体
	 */
	public void modify(T entity);

	/**
	 * <p>
	 * 通过名字查找
	 * </p>
	 * 
	 * @param id :
	 *            id
	 * @return 找到的实体
	 */
	public T findById(K id);

	/**
	 * <p/> 查找全部实体 <p/>
	 * 
	 * @return 所有实体的列表
	 */
	public List<T> findAll();

	/**
	 * <p>
	 * 计算匹配查询条件的记录总数,如果没有注入或者设置hql语句,将使用默认的查询语句返回数据库中所有记录
	 * </p>
	 * 
	 * @return 记录总数
	 */
	public int getTotalRows();

	/**
	 * <p>
	 * 根据每页记录的数量,计算出总的分页数
	 * </p>
	 * 
	 * @param size
	 *            每页记录的数量
	 * @return 分页总数
	 */
	public int getPageSize(int size);

	/**
	 * <p/> 根据给定的页码进行分页查找,这是纯Hibernate分页. <p/>
	 * 
	 * @param page :
	 *            要查询的页码 查询的hql语句
	 * @param size :
	 *            每页记录数 分页信息,参见PageInfo
	 * @return 匹配的实体列表
	 */
	public List<T> findByPage(final int page, final int size);
	
	/**
	 * 根据给定的起始索引值查询记录数,这是纯Hibernate分页
	 * @param startIndex
	 *					第一条记录的索引值
	 * @param pageCount
	 * 					查询记录数
	 * @return 匹配的实体列表
	 */
	public List<T> findByCount(final int startIndex, final int pageCount);
	
	/**
	 * 分页查询
	 * @param startRow 开始位置
	 * @param pageSize 查询条数
	 */
	public List getQueryResult(int startRow, int pageSize);
}
