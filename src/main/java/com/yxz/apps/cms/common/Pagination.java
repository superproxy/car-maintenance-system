package com.yxz.apps.cms.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-6
 * Time: 下午9:49
 * To change this template use File | Settings | File Templates.
 */

public class Pagination {

    int totalCount = 0;
    int rowsPerPage = 20;
    int currentPageNum = 1;
    int totalPageNum;


    List<Integer> pageRowsList = new ArrayList<Integer>();

    public Pagination() {
        //  默认初始化的
        pageRowsList.add(10);
        pageRowsList.add(20);
        pageRowsList.add(50);
        pageRowsList.add(100);
    }

    public List<Integer> getPageRowsList() {
        return pageRowsList;
    }

    public void setPageRowsList(List<Integer> pageRowsList) {
        this.pageRowsList = pageRowsList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }
}
