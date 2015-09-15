package com.yxz.apps.cms.car.service.impl;

import com.yxz.apps.cms.car.dao.CarDao;
import com.yxz.apps.cms.car.service.CarService;
import com.yxz.apps.cms.po.hibernate.Car;
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
public class CarServiceImpl implements CarService {

    @Resource
    private CarDao carDao;

    @Transactional
    @Override
    public Car getBeanById(String id) throws Exception {
        return carDao.findById(id);
    }

    @Transactional
    @Override
    public List<Car> queryCar() throws Exception {
        return carDao.findAll();
    }

    @Transactional
    @Override
    public List<Car> queryCar(String condition) throws Exception {
        return carDao.query(condition);
    }

    @Transactional
    @Override
    public void save(Car CarEntity) throws Exception {
        carDao.add(CarEntity);
    }

    @Transactional
    @Override
    public void edit(Car CarEntity) throws Exception {
        carDao.update(CarEntity);
    }

    @Transactional
    @Override
    public void remove(String id) throws Exception {
        Car entity = carDao.findById(id);
        carDao.remove(entity);
    }

    @Transactional
    @Override
    public int getTotalCount() {
        return carDao.getTotalRows();
    }

    @Transactional
    @Override
    public int getTotalCount(String condition) {
        return carDao.getTotalRows(condition);
    }

    @Transactional
    @Override
    public List<Car> queryByPagination(int startIndex, int rowsPerPage) {
        return carDao.findByPagination(startIndex, rowsPerPage);
    }

    @Transactional
    @Override
    public List<Car> queryByPagination(int startIndex, int rowsPerPage, String condtion) {
        return carDao.findByPagination(startIndex, rowsPerPage, condtion);
    }
}
