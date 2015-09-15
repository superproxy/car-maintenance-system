<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<table class="table">
    <thead>
    <tr>
        <th width="100">单号</th>
        <th width="100">购买人</th>
        <th width="100">购买时间</th>
        <th width="100">录入时间</th>
        <th width="100">总金额</th>
        <th width="100">折扣</th>
        <th width="100">查看</th>
        <th width="100">编辑</th>
        <th width="100">删除</th>
    </tr>
    <thead>

    <tbody>
    <c:forEach items="${orderEntityList}" var="maintiance">
        <tr>
            <td><c:out value="${maintiance.buyId}"/>
            </td>
            <td><c:out value="${maintiance.buyPerson}"/>
            </td>
            <td>
                <c:out value="${maintiance.buyDate}"/>
            </td>
            <td>
                <c:out value="${maintiance.inputDate}"/>
            </td>
            <td>
                <c:out value="${maintiance.totalPrice}"/>
            </td>
            <td>
                <c:out value="${maintiance.discount}"/>
            </td>
            <td>
                <a href="<c:out value="${pageContext.request.contextPath}/template/${maintiance.buyId}/show"/>" target="dialog"> 详情</a>
            </td>
            <td>
                <a href="<c:out value="${pageContext.request.contextPath}/template/${maintiance.buyId}/edit"/>" target="dialog"> 编辑</a>
            </td>
            <td>
                <a href="<c:out value="${pageContext.request.contextPath}/template/${maintiance.buyId}/delete"/>" target="ajaxTodo" title="确定要删除吗?">
                    删除</a>
                    <%--<a href="<c:out value="${orderEntity.buyId}/delete"/>">删除</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
