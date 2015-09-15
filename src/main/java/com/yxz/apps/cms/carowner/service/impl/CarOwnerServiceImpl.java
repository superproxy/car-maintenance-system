package com.yxz.apps.cms.carowner.service.impl;

import com.yxz.apps.cms.carowner.service.CarOwnerService;
import com.yxz.apps.cms.po.hibernate.CarOwner;
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
public class CarOwnerServiceImpl implements CarOwnerService {

    @Resource
    private com.yxz.apps.cms.carowner.dao.CarOwnerDao carOwnerDao;

    @Transactional
    @Override
    public CarOwner getBeanById(String id) throws Exception {
        return carOwnerDao.findById(Integer.valueOf(id));
    }

    @Transactional
    @Override
    public List<CarOwner> queryCarOwner() throws Exception {
        return carOwnerDao.findAll();
    }

    @Transactional
    @Override
    public List<CarOwner> queryCarOwner(String condition) throws Exception {
        return carOwnerDao.query(condition);
    }

    @Transactional
    @Override
    public void save(CarOwner CarOwnerEntity) throws Exception {
        carOwnerDao.add(CarOwnerEntity);
    }

    @Transactional
    @Override
    public void edit(CarOwner CarOwnerEntity) throws Exception {
        carOwnerDao.update(CarOwnerEntity);
    }

    @Transactional
    @Override
    public void remove(String id) throws Exception {
        CarOwner entity = carOwnerDao.findById(Integer.valueOf(id));
        carOwnerDao.remove(entity);
    }

    @Transactional
    @Override
    public int getTotalCount() {
        return carOwnerDao.getTotalRows();
    }

    @Transactional
    @Override
    public int getTotalCount(String condition) {
        return carOwnerDao.getTotalRows(condition);
    }

    @Transactional
    @Override
    public List<CarOwner> queryByPagination(int startIndex, int rowsPerPage) {
        return carOwnerDao.findByPagination(startIndex, rowsPerPage);
    }

    @Transactional
    @Override
    public List<CarOwner> queryByPagination(int startIndex, int rowsPerPage, String condition) {
        return carOwnerDao.findByPagination(startIndex, rowsPerPage, condition);
    }
}
