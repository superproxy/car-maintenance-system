package com.yxz.apps.cms.maintance.service.impl;

import com.yxz.apps.cms.maintance.service.MaintanceService;
import com.yxz.apps.cms.maintance.dao.MaintanceDao;
import com.yxz.apps.cms.po.hibernate.Maintance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yxz
 * Date: 13-2-6
 * Time: 下午10:52
 * To change this template use File | Settings | File Templates.
 */

@Service
public class MaintanceServiceImpl implements MaintanceService {

    @Resource
    private MaintanceDao maintanceDao;

    @Transactional
    @Override
    public Maintance getBeanById(String id) throws Exception {
        return maintanceDao.findById(id);
    }

    @Transactional
    @Override
    public List<Maintance> queryMaintance() throws Exception {
        return maintanceDao.findAll();
    }

    @Transactional
    @Override
    public List<Maintance> queryMaintance(String condition) throws Exception {
        return maintanceDao.query(condition);
    }

    @Transactional
    @Override
    public void save(Maintance MaintanceEntity) throws Exception {
        maintanceDao.add(MaintanceEntity);
    }

    @Transactional
    @Override
    public void edit(Maintance MaintanceEntity) throws Exception {
        maintanceDao.update(MaintanceEntity);
    }

    @Transactional
    @Override
    public void remove(String id) throws Exception {
        Maintance entity = maintanceDao.findById(id);
        maintanceDao.remove(entity);
    }

    @Transactional
    @Override
    public int getTotalCount() {
        return maintanceDao.getTotalRows();
    }

    @Override
    public List<Maintance> queryByPagination(int startIndex, int rowsPerPage) {
        return maintanceDao.findByPagination(startIndex, rowsPerPage);
    }
}
