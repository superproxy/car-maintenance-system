package com.yxz.apps.cms.common.dao;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-24
 * Time: 下午8:50
 * ORM开发速度快
 * Runtime级别的异常
 */
public interface GenericDao<T, K> {

    /**
     * 添加
     */
    T add(T bean);

    /**
     * 查询
     */
    List query(String hql);

    /**
     * 编辑
     *
     * @param bean
     */
    void update(T bean);

    /**
     * <p>
     * 删除实体
     * </p>
     *
     * @param entity :
     *               实体
     */
    void remove(T entity);

    /**
     * <p>
     * 删除实体集合
     * </p>
     *
     * @param entities :
     *                 实体
     */
    void removeAll(Collection<T> entities);

    /**
     * <p>
     * 通过名字查找
     * </p>
     *
     * @param id :
     *           id
     * @return 找到的实体
     */
    T findById(K id);

    /**
     * <p/> 查找全部实体 <p/>
     *
     * @return 所有实体的列表
     */
    List<T> findAll();

    /**
     * <p>
     * 计算匹配查询条件的记录总数,如果没有注入或者设置hql语句,将使用默认的查询语句返回数据库中所有记录
     * </p>
     *
     * @return 记录总数
     */
    int getTotalRows();

    /**
     * 带查询条件的总数
     *
     * @param condition
     * @return
     */
    int getTotalRows(String condition);

    List<T> findByPagination(int startIndex, int pageCount);

    /**
     * 带条件的分页查询
     */
    List<T> findByPagination(final int startIndex, final int count, String condition);

//    /**
//     * <p>
//     * 根据每页记录的数量,计算出总的分页数
//     * </p>
//     *
//     * @param size 每页记录的数量
//     * @return 分页总数
//     */
//    public int getPageSize(int size);
//
//    /**
//     * <p/> 根据给定的页码进行分页查找,这是纯Hibernate分页. <p/>
//     *
//     * @param page :
//     *             要查询的页码 查询的hql语句
//     * @param size :
//     *             每页记录数 分页信息,参见PageInfo
//     * @return 匹配的实体列表
//     */
//    public List<T> findByPage(final int page, final int size);
//
//    /**
//     * 根据给定的起始索引值查询记录数,这是纯Hibernate分页
//     *
//     * @param startIndex 第一条记录的索引值
//     * @param pageCount  查询记录数
//     * @return 匹配的实体列表
//     */
//    public List<T> findByPagination(final int startIndex, final int pageCount);
//
//    /**
//     * 分页查询
//     *
//     * @param startRow 开始位置
//     * @param pageSize 查询条数
//     */
//    public List getQueryResult(int startRow, int pageSize);
}
