package com.yxz.apps.cms.car.service;

import com.yxz.apps.cms.po.hibernate.Car;

import java.util.List;

/**
 * @author: Edward
 * Date: 13-3-26
 * Time: 下午8:50
 * Description:
 */
public interface CarService {
    Car getBeanById(String id) throws Exception;

    /**
     * 获取所有信息
     *
     * @return
     */
    List<Car> queryCar() throws Exception;

    List<Car> queryCar(String condition) throws Exception;

    void save(Car CarEntity) throws Exception;

    void edit(Car CarEntity) throws Exception;

    /**
     * 删除
     *
     * @param id
     */
    void remove(String id) throws Exception;

    /**
     * 获取总共的条数
     *
     * @return
     */
    int getTotalCount();

    int getTotalCount(String condition);

    /**
     * @param startIndex
     * @param rowsPerPage
     * @return
     */
    List<Car> queryByPagination(int startIndex, int rowsPerPage);

    List<Car> queryByPagination(int startIndex, int rowsPerPage, String condition);
}
