<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<%--'command' 默认的 modelAttribute--%>
<form:form method="POST" action="${pageContext.request.contextPath}/template/edit" modelAttribute="orderEntity">
    <table>
        <tr>
            <td>buyId:</td>
            <td><form:input path="buyId" disabled="true"/></td>
        </tr>
        <tr>
            <td>buyPerson:</td>
            <td><form:input path="buyPerson"/></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
</form:form>
