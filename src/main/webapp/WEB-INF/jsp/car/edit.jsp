<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<%--'command' 默认的 modelAttribute--%>
<%--<form:form method="POST" action="/car/edit" modelAttribute="car">--%>
<div class="pageContent">
    <%--<form name="form" action="/car/update" method="post"  >--%>

    <form method="post" action="${pageContext.request.contextPath}/car/update" class="pageForm required-validate"
          onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent" layoutH="56">


            <p>
                <label>车牌:</label>
                <input type="text" name="carCard" value="${car.carCard}" readonly="readonly"/>
            </p>


            <p>
                <label>车主：</label>
                <input id="carOwnerId" name="carOwnerId" value="${car.carOwnerId}" type="hidden"/>
                <input type="text" id="carOwnerName" name="carOwnerName" postField="keyword"
                       value="${car.carOwnerName}"
                <%--显示的字段--%>
                       suggestFields="carOwnerName,carOwnerPhone, carOwnerAddress"
                       suggestUrl="${pageContext.request.contextPath}/carOwner/queryCarOwner"/>
                <a class="btnLook" href="${pageContext.request.contextPath}/carOwner/queryCarOwner">查找带回</a>
                <%--<span class="info">(suggest+lookup)</span>--%>
            </p>

            <p>
                <label>登记时间：</label>
                <input type="text" id="inputTime" name="inputTime" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                       value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${car.inputTime}" />"
                       class="required" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>
        </div>


        <div class="formBar">
            <ul>
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>

    </form>

</div>
