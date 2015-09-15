package com.yxz.apps.cms.maintance.service;

import com.yxz.apps.cms.po.hibernate.Maintance;

import java.util.List;

/**
 * @author: Edward
 * Date: 13-3-26
 * Time: 下午8:50
 * Description:
 */
public interface MaintanceService {
    Maintance getBeanById(String id) throws Exception;

    /**
     * 获取所有信息
     *
     * @return
     */
    List<Maintance> queryMaintance() throws Exception;

    List<Maintance> queryMaintance(String condition) throws Exception;

    void save(Maintance MaintanceEntity) throws Exception;

    void edit(Maintance MaintanceEntity) throws Exception;

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
    List<Maintance> queryByPagination(int startIndex, int rowsPerPage);
}
