package com.yxz.apps.cms.peijian.service;

import com.yxz.apps.cms.po.hibernate.Order;

import java.util.List;

/**
 * @author: Edward
 * Date: 13-3-26
 * Time: 下午8:50
 * Description:
 */
public interface OrderService {
    Order getBeanById(String id) throws Exception;

    /**
     * 获取所有信息
     *
     * @return
     */
    List<Order> queryOrder() throws Exception;

    List<Order> queryOrder(String condition) throws Exception;

    void save(Order orderEntity) throws Exception;

    void edit(Order orderEntity) throws Exception;

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
     * @param startIndex
     * @param rowsPerPage
     * @return
     */
    List<Order> queryByPagination(int startIndex, int rowsPerPage);
}
