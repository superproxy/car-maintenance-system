package com.yxz.apps.cms.maintance.dao.impl;

import com.yxz.apps.cms.common.dao.impl.hibernate.GenericDaoByHibernate;
import com.yxz.apps.cms.maintance.dao.MaintanceDao;
import com.yxz.apps.cms.po.hibernate.Maintance;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-24
 * Time: 下午8:48
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class MaintanceDaoImpl extends GenericDaoByHibernate<Maintance, String> implements MaintanceDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    protected HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }


}