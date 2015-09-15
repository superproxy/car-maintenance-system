<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>


<%--<!--  换页的时候改变-->--%>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/carOwner/list">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="numPerPage" value="${page.rowsPerPage}"/>
</form>


<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);"
          action="${pageContext.request.contextPath}/carOwner/list"
          method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        车主：<input type="text" name="carOwnerName" value="${carOwnerName}"/>
                    </td>
                </tr>
            </table>
            <div class="subBar">
                <ul>
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">检索</button>
                            </div>
                        </div>
                    </li>
                    <li><a class="button" href="${pageContext.request.contextPath}/carOwner/advancedSearch"
                           target="dialog" mask="true"
                           title="查询框"><span>高级检索</span></a></li>
                </ul>
            </div>
        </div>
    </form>
</div>


<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${pageContext.request.contextPath}/carOwner/add"
                   target="dialog"><span>添加</span></a>
            </li>
            <li><a class="detail" href="${pageContext.request.contextPath}/carOwner/{carOwnerId}/show"
                   target="dialog"><span>详情</span></a>
            </li>
            <li><a class="edit" href="${pageContext.request.contextPath}/carOwner/{carOwnerId}/edit"
                   target="dialog"><span>修改</span></a></li>
            <li><a class="delete" href="${pageContext.request.contextPath}/carOwner/{carOwnerId}/delete"
                   target="ajaxTodo"
                   title="确定要删除吗?"><span>删除</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="${pageContext.request.contextPath}/carOwner/export" target="dwzExport"
                   targetType="navTab"
                   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>


    <table class="table">
        <thead>
        <tr>
            <th width="100">车主</th>
            <th width="150">手机号</th>
            <th width="200">地址</th>
            <th width="150">登记时间</th>
            <th width="100">操作</th>
            <th width="100">操作</th>
            <th width="100">操作</th>
        </tr>
        <thead>

        <tbody>

        <c:forEach items="${carOwnerList}" var="carOwner">
            <%--跟踪订单ID--%>
            <tr target="carOwnerId" rel="<c:out value="${carOwner.carOwnerId}"/>">
                <td>
                    <c:out value="${carOwner.carOwnerName}"/>
                </td>
                <td>
                    <c:out value="${carOwner.carOwnerPhone}"/>
                </td>
                <td>
                    <c:out value="${carOwner.carOwnerAddress}"/>
                </td>
                <td>
                    <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${carOwner.inputTime}"/>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/carOwner/${carOwner.carOwnerId}/show"/>"
                       target="dialog"> 详情</a>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/carOwner/${carOwner.carOwnerId}/edit"/>"
                       target="dialog"> 编辑</a>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/carOwner/${carOwner.carOwnerId}/delete"/>"
                       target="ajaxTodo" title="确定要删除吗?"> 删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%@ include file="/WEB-INF/jsp/common/pagination.jsp" %>
</div>