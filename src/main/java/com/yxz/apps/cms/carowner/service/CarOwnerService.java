package com.yxz.apps.cms.carowner.service;

import com.yxz.apps.cms.po.hibernate.CarOwner;

import java.util.List;

/**
 * @author: Edward
 * Date: 13-3-26
 * Time: 下午8:50
 * Description:
 */
public interface CarOwnerService {
    CarOwner getBeanById(String id) throws Exception;

    /**
     * 获取所有信息
     *
     * @return
     */
    List<CarOwner> queryCarOwner() throws Exception;

    List<CarOwner> queryCarOwner(String condition) throws Exception;

    void save(CarOwner CarOwnerEntity) throws Exception;

    void edit(CarOwner CarOwnerEntity) throws Exception;

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


    /**
     * 获取总共的条数
     *
     * @return
     */
    int getTotalCount(String condition);

    /**
     * @param startIndex
     * @param rowsPerPage
     * @return
     */
    List<CarOwner> queryByPagination(int startIndex, int rowsPerPage);

    /**
     * @param startIndex
     * @param rowsPerPage
     * @return
     */
    List<CarOwner> queryByPagination(int startIndex, int rowsPerPage, String codition);
}
