<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>


<%--<!--  换页的时候改变-->--%>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/car/list">
    <input type="hidden" name="pageNum" value="1"/>
    <input type="hidden" name="numPerPage" value="${page.rowsPerPage}"/>
</form>


<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);"
          action="${pageContext.request.contextPath}/car/list"
          method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        车牌：<input type="text" class="date" readonly="true" name="carCard" value="${carCard}"/>
                    </td>
                    <td>
                        车主：<input type="text" class="date" readonly="true" name="carOwner" value="${carOwnerName}"/>
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
                    <li><a class="button" href="${pageContext.request.contextPath}/car/advancedSearch"
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
            <li><a class="add" href="${pageContext.request.contextPath}/car/add"
            <%--target="navTab" ref="new"><span>添加</span></a>--%>
                   target="dialog"><span>添加</span></a>
            </li>
            <li><a class="detail" href="${pageContext.request.contextPath}/car/{carCard}/show"
                   target="dialog"><span>详情</span></a>
            </li>
            <li><a class="edit" href="${pageContext.request.contextPath}/car/{carCard}/edit"
                   target="dialog"><span>修改</span></a></li>
            <li><a class="delete" href="${pageContext.request.contextPath}/car/{carCard}/delete" target="ajaxTodo"
                   title="确定要删除吗?"><span>删除</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="${pageContext.request.contextPath}/car/export" target="dwzExport"
                   targetType="navTab"
                   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>


    <table class="table">
        <thead>
        <tr>
            <th width="100">车牌</th>
            <th width="100">车主</th>
            <th width="100">车型</th>
            <th width="100">登记时间</th>
            <th width="100">操作</th>
            <th width="100">操作</th>
            <th width="100">操作</th>
        </tr>
        <thead>

        <tbody>

        <c:forEach items="${carList}" var="car">
            <%--跟踪订单ID--%>
            <tr target="carCard" rel="<c:out value="${car.carCard}"/>">
                <td>
                    <c:out value="${car.carCard}"/>
                </td>
                <td>
                    <c:out value="${car.carOwnerName}"/>
                </td>
                <td>
                    <c:out value="${car.carType}"/>
                </td>
                <td>
                    <c:out value="${car.inputTime}"/>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/car/${car.carCard}/show"/>"
                       target="dialog"> 详情</a>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/car/${car.carCard}/edit"/>"
                       target="dialog"> 编辑</a>
                </td>
                <td>
                    <a href="<c:out value="${pageContext.request.contextPath}/car/${car.carCard}/delete"/>"
                       target="ajaxTodo" title="确定要删除吗?"> 删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%@ include file="/WEB-INF/jsp/common/pagination.jsp" %>
</div>