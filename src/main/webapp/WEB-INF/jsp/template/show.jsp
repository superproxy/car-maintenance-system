<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<div class="pageHeader">

    <form action="/render.do?method=search" method="post" onsubmit="return navTabSearch(this)">

        <input type="hidden" name="resourceStatus" value="${param.resourceStatus}"/>

        <input type="hidden" name="pageNum" value="1"/>

        <input type="hidden" name="orderField" value="${param.orderField}"/>

        <div class="searchBar">

            <div class="searchContent">

                <select name="resourceType">

                    <option value="">全部栏目</option>

                    <!--<c:forEach var="item" items="${model.resourceTypes}">-->

                    <!--<option value="${item.id}"-->
                    <!--${param.resourceType eq item.id?"selected":"" }>${item.name}</option>-->

                    <!--</c:forEach>-->

                </select>

                <input name="keywords" type="text" size="25" value="${param.keywords}"/>

            </div>

            <div class="subBar">

                <ul>

                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">检索</button>
                            </div>
                        </div>
                    </li>

                </ul>

            </div>

        </div>

    </form>

</div>


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


<form id="pagerForm" action="xxx" method="post">

    <input type="hidden" name="pageNum" value="1"/><!--【必须】value=1可以写死-->

    <input type="hidden" name="numPerPage" value="20"/><!--【可选】每页显示多少条-->

    <input type="hidden" name="orderField" value="xxx"/><!--【可选】查询排序-->

    <!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数-->

    <input type="hidden" name="status" value="active"/>

</form>


<div class="pagination" targetType="navTab"
     totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>


<a class="delete" href="__URL__/foreverdelete/id/{sid_user}/navTabId/__MODULE__" target="ajaxTodo" title="你确定要删除吗？"
   warn="请选择用户"><span>删除</span></a>


<a class="edit" href="__URL__/edit/id/{sid_user}" target="dialog" mask="true" warn="请选择用户"><span>编辑</span></a>


<a class="icon" href="__URL__/password/id/{sid_user}" target="dialog" mask="true" warn="请选择用户"><span>修改密码</span></a>







