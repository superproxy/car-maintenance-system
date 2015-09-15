package com.yxz.apps.cms.carowner.dao.impl;

import com.yxz.apps.cms.carowner.dao.CarOwnerDao;
import com.yxz.apps.cms.common.dao.impl.hibernate.GenericDaoByHibernate;
import com.yxz.apps.cms.po.hibernate.CarOwner;
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
public class CarOwnerDaoImpl extends GenericDaoByHibernate<CarOwner, Integer> implements CarOwnerDao {

    @Resource
    private HibernateTemplate hibernateTemplate;

    @Override
    protected HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }


}