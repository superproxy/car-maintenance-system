package com.yxz.apps.cms.common.dao.impl.hibernate;

import com.yxz.apps.cms.common.dao.GenericDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
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
public abstract class GenericDaoByHibernate<T, K> implements GenericDao<T, K> {

    protected Class<T> persistenceClass = (Class<T>) DAOUtil.getTypeArguments(GenericDaoByHibernate.class, this.getClass()).get(0);

    @Override
    public T add(T bean) {
        return (T) this.getHibernateTemplate().save(bean);
    }

    protected abstract HibernateTemplate getHibernateTemplate();

    /**
     * @param hql
     * @return
     */
    @Override
    public List query(String hql) {
        return this.getHibernateTemplate().find(hql);
    }

    @Override
    public T findById(K id) {
        return (T) getHibernateTemplate().get(persistenceClass, (Serializable) id);
    }

    @Override
    public void remove(T entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void removeAll(Collection<T> entities) {
        getHibernateTemplate().deleteAll(entities);
    }

    @Override
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public List<T> findAll() {
        String hql = "from " + persistenceClass.getName();
        return (List<T>) getHibernateTemplate().find(hql);
    }

    @Override
    public int getTotalRows() {
        return getTotalRows(null);
    }

    @Override
    public int getTotalRows(String condition) {
        String hql = " select count(*) from " + persistenceClass.getName();
        if (condition != null && !condition.isEmpty()) {
            hql += " where " + condition;
        }
        return ((Long) getHibernateTemplate().find(hql).get(0)).intValue();

    }

//    /**
//     * @param size 每页记录的数量
//     * @return
//     */
//    @Override
//    public int getPageSize(int size) {
//        // 最大页数
//        int pageSize;
//        // 实际每页数据条数
//        int actualSize;
//        // 总记录数
//        int totalRows = this.getTotalRows();
//        // 计算实际每页的条数,如果请求的每页数据条数大于总条数, 则等于总条数
//        actualSize = (size > totalRows) ? totalRows : size;
//        if (totalRows > 0) {
//            pageSize = (totalRows % actualSize == 0) ? (totalRows / actualSize)
//                    : (totalRows / actualSize + 1);
//        } else {
//            pageSize = 0;
//        }
//        return pageSize;
//    }


    /**
     * 分页查询
     *
     * @param startIndex 第一条记录的索引值， 从0开始
     * @param count      查询记录数
     * @return
     */
    @Override
    public List<T> findByPagination(final int startIndex, final int count, String condition) {
        String where = "";
        if (condition != null && condition.length() > 0) {
            where = " where " + condition;
        }
        final String hql = "from " + persistenceClass.getName() + where;
        //hql参数列表
        final List params = new ArrayList();
        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public List<T> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery(hql);
                if (params != null && params.size() > 0) {
                    int index = 0;
                    for (Object obj : params) {
                        query.setParameter(index, obj);
                        index++;
                    }
                }
                // 设置第一条记录
                query.setFirstResult(startIndex);
                //  设置总的返回条数
                query.setMaxResults(count);
                return (List<T>) query.list();
            }
        });
    }

    /**
     * 分页查询
     *
     * @param startIndex 第一条记录的索引值， 从0开始
     * @param count      查询记录数
     * @return
     */
    @Override
    public List<T> findByPagination(final int startIndex, final int count) {
        return findByPagination(startIndex, count, null);
    }


}
