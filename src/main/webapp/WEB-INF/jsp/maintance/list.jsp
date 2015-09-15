<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>


<%--<!--  换页的时候改变-->--%>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/maintance/list">
    <%--<input type="hidden" name="status" value="${param.status}">--%>
    <%--<input type="hidden" name="keywords" value="${param.keywords}"/>--%>
    <%--<input type="hidden" name="pageNum" value="${page.currentPageNum}"/>--%>
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="numPerPage" value="${page.rowsPerPage}"/>
    <%--<input type="hidden" name="orderField" value="${param.orderField}"/>--%>
</form>


<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);"
          action="${pageContext.request.contextPath}/maintance/list"
          method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        维修单号：<input type="text" name="maintanceId" value="${maintanceId}"/>
                    </td>
                    <td>
                        车牌：<input type="text" class="date" readonly="true" name="buyDate" value="${carCard}"/>
                    </td>
                    <td>
                        车主：<input type="text" class="date" readonly="true" name="buyDate" value="${carOwner}"/>
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
                    <li><a class="button" href="${pageContext.request.contextPath}/maintance/advancedSearch"
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
            <li><a class="add" href="${pageContext.request.contextPath}/maintance/add"
            <%--target="navTab" ref="new"><span>添加</span></a>--%>
                   target="dialog"><span>添加</span></a>
            </li>
            <li><a class="detail" href="${pageContext.request.contextPath}/maintance/{maintanceId}/show"
                   target="dialog"><span>详情</span></a>
            </li>
            <li><a class="edit" href="${pageContext.request.contextPath}/maintance/{maintanceId}/edit"
                   target="dialog"><span>修改</span></a></li>
            <li><a class="delete" href="${pageContext.request.contextPath}/maintance/{maintanceId}/delete"
                   target="ajaxTodo"
                   title="确定要删除吗?"><span>删除</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="${pageContext.request.contextPath}/maintance/export" target="dwzExport"
                   targetType="navTab"
                   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>


    <table class="table">
        <thead>
        <tr>
            <th width="100">维修单号</th>
            <th width="100">车牌</th>
            <th width="100">车主</th>
            <th width="100">故障原因</th>
            <th width="100">接车时间</th>
            <th width="100">维修时间</th>
            <th width="100">维修完成时间</th>
            <th width="100">取车时间</th>
            <th width="100">操作</th>
            <th width="100">操作</th>
            <th width="100">操作</th>
        </tr>
        <thead>

        <tbody>

        <c:forEach items="${maintanceList}" var="maintance">
            <%--跟踪订单ID--%>
            <tr target="maintanceId" rel="<c:out value="${maintance.maintanceId}"/>">
                <td><c:out value="${maintance.maintanceId}"/>
                </td>
                <td><c:out value="${maintance.carCard}"/>
                </td>
                <td>
                    <c:out value="${maintance.carOwnerId}"/>
                </td>
                <td>
                    <c:out value="${maintance.failReason}"/>
                </td>
                <td>
                    <c:out value="${maintance.receiveTime}"/>
                </td>
                <td>
                    <c:out value="${maintance.repaireTime}"/>
                </td>
                <td>
                    <c:out value="${maintance.finishedTime}"/>
                </td>
                <td>
                    <c:out value="${maintance.takenTime}"/>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/maintance/${maintance.maintanceId}/show"/>"
                       target="dialog"> 详情</a>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/maintance/${maintance.maintanceId}/edit"/>"
                       target="dialog"> 编辑</a>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/maintance/${maintance.maintanceId}/delete"/>"
                       target="ajaxTodo"
                       title="确定要删除吗?">
                        删除</a>
                        <%--<a href="<c:out value="${orderEntity.maintanceId}/delete"/>">删除</a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%@ include file="/WEB-INF/jsp/common/pagination.jsp" %>
</div>