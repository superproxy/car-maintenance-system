package com.yxz.apps.cms.common.dao.impl.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


/**
 * <p/>
 * 基本DAO泛型接口的实现
 * </P>
 *
 * @param <T>
 * @param <K>
 * @author chenming
 */
public class GenericDaoImpl<T, K extends Serializable> implements
        GenericDao<T, K> {

    /**
     * 具体的实体类型
     */
    private Class<T> type;
    /**
     * Spring提供的Hibernate工具类
     */
    private HibernateTemplate hibernateTemplate;
    /**
     * Spring提供的Jdbc工具类
     */
    private JdbcTemplate jdbcTemplate;
    /**
     * 查询条件
     */
    private String hql;
    /**
     * hql参数列表
     */
    private List params = null;

    /**
     * <p/>
     * 必须提供的构造方法,以便创建实例的时候就知道具体实体的类型
     * <p/>
     *
     * @param type :
     *             实体类型
     */
    public GenericDaoImpl(Class<T> type) {
        this.type = type;
        this.hql = "from " + type.getName();
    }

    public void setHql(String hql, List params) {
        this.hql = hql;
        this.params = params;
    }

    public void reSetHql() {
        this.hql = "from " + type.getName();
        this.params = null;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    /**
     * <p>
     * 因为这个类没有继承HibernateDaoSupport,所以现在由Spring注入HibernateTemplate
     * </p>
     *
     * @param hibernateTemplate :
     *                          Spring提供的Hibernate工具类
     */
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
        this.params = null;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        String hql = "from " + type.getName();
        return (List<T>) hibernateTemplate.find(hql);
    }

    @SuppressWarnings("unchecked")
    public T findById(K id) {
        return (T) hibernateTemplate.get(type, id);
    }

    public void modify(T entity) {
        hibernateTemplate.update(entity);
    }

    public void remove(T entity) {
        hibernateTemplate.delete(entity);
    }

    public void removeAll(Collection<T> entities) {
        hibernateTemplate.deleteAll(entities);
    }

    @SuppressWarnings("unchecked")
    public K save(T entity) {
        return (K) hibernateTemplate.save(entity);
    }

    //总记录数
    public int getTotalRows() {
        String actualHql = "select count(*) "
                + hql.substring(hql.indexOf("from"));
        if (params != null && params.size() > 0) {
            return ((Long) this.hibernateTemplate.find(actualHql,
                    params.toArray()).get(0)).intValue();
        } else {
            return ((Long) this.hibernateTemplate.find(actualHql).get(0))
                    .intValue();
        }

    }

    public int getPageSize(int size) {
        // 最大页数
        int pageSize;
        // 实际每页数据条数
        int actualSize;
        // 总记录数
        int totalRows = this.getTotalRows();
        // 计算实际每页的条数,如果请求的每页数据条数大于总条数, 则等于总条数
        actualSize = (size > totalRows) ? totalRows : size;
        if (totalRows > 0) {
            pageSize = (totalRows % actualSize == 0) ? (totalRows / actualSize)
                    : (totalRows / actualSize + 1);
        } else {
            pageSize = 0;
        }
        return pageSize;
    }

    @SuppressWarnings("unchecked")
    //从page开始
    public List<T> findByPage(final int page, final int size) {
        final int pageSize = this.getPageSize(size);//总页数
        final int totalRows = this.getTotalRows();//总记录数
        return hibernateTemplate.executeFind(new HibernateCallback() {
            public List<T> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                // 实际页码
                int actualPage = (page > pageSize) ? pageSize : page;
                // 计算实际每页的条数,如果请求的每页数据条数大于总条数, 则等于总条数
                int actualSize = (size > totalRows) ? totalRows : size;
                // 计算请求页码的第一条记录的索引值,如果
                int startRow = (actualPage > 0) ? (actualPage - 1) * actualSize
                        : 0;
                Query query = session.createQuery(hql);
                if (params != null && params.size() > 0) {
                    int index = 0;
                    for (Object obj : params) {
                        query.setParameter(index, obj);
                        index++;
                    }
                }
                // 设置第一条记录
                query.setFirstResult(startRow);
                query.setMaxResults(actualSize);
                return (List<T>) query.list();
            }
        });
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCount(final int startIndex, final int pageCount) {
        final int totalRows = this.getTotalRows();//总记录数
        return hibernateTemplate.executeFind(new HibernateCallback() {
            public List<T> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                // 计算第一条记录的索引值
                int startRow = (startIndex > totalRows) ? totalRows : startIndex;
                // 计算返回总条数
                int actualSize = (pageCount > 0) ? pageCount : 0;
                Query query = session.createQuery(hql);
                if (params != null && params.size() > 0) {
                    int index = 0;
                    for (Object obj : params) {
                        query.setParameter(index, obj);
                        index++;
                    }
                }
                // 设置第一条记录
                query.setFirstResult(startRow);
                query.setMaxResults(actualSize);
                return (List<T>) query.list();
            }
        });
    }

    //从第startRow条开始
    public List getQueryResult(final int startRow, final int pageSize) {
        final int totalRows = this.getTotalRows();
        return hibernateTemplate.executeFind(new HibernateCallback() {
            public List<T> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                // 计算实际每页的条数,如果请求的每页数据条数大于总条数, 则等于总条数
                int actualSize = (pageSize > totalRows) ? totalRows : pageSize;
                Query query = session.createQuery(hql);
                if (params != null && params.size() > 0) {
                    int index = 0;
                    for (Object obj : params) {
                        query.setParameter(index, obj);
                        index++;
                    }
                }
                // 设置第一条记录
                query.setFirstResult(startRow);
                query.setMaxResults(actualSize);
                return (List<T>) query.list();
            }
        });

    }


}
