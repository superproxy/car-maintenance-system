package com.yxz.apps.cms.peijian.service.impl;

import com.yxz.apps.cms.peijian.dao.OrderDao;
import com.yxz.apps.cms.peijian.service.OrderService;
import com.yxz.apps.cms.po.hibernate.Order;
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
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Transactional
    @Override
    public Order getBeanById(String id) throws Exception {
        return orderDao.findById(Long.valueOf(id));
    }

    @Transactional
    @Override
    public List<Order> queryOrder() throws Exception {
        return orderDao.findAll();
    }

    @Transactional
    @Override
    public List<Order> queryOrder(String condition) throws Exception {
        return orderDao.query(condition);
    }

    @Transactional
    @Override
    public void save(Order orderEntity) throws Exception {
        orderDao.add(orderEntity);
    }

    @Transactional
    @Override
    public void edit(Order orderEntity) throws Exception {
        orderDao.update(orderEntity);
    }

    @Transactional
    @Override
    public void remove(String id) throws Exception {
        Order entity = orderDao.findById(Long.valueOf(id));
        orderDao.remove(entity);
    }

    @Transactional
    @Override
    public int getTotalCount() {
        return orderDao.getTotalRows();
    }

    @Override
    public List<Order> queryByPagination(int startIndex, int rowsPerPage) {
        return orderDao.findByPagination(startIndex, rowsPerPage);
    }
}
