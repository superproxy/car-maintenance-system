<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%--'command' 默认的 modelAttribute--%>
<form:form method="POST" action="${pageContext.request.contextPath}/template/add" modelAttribute="orderEntity">
    <table>
        <tr>
            <td>buyId:</td>
            <td><form:input path="buyId"/></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
</form:form>

