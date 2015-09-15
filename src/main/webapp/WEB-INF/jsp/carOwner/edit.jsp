<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<%--'command' 默认的 modelAttribute--%>
<%--<form:form method="POST" action="/carOwner/edit" modelAttribute="carOwner">--%>
<div class="pageContent">
    <%--<form name="form" action="/carOwner/update" method="post"  >--%>

    <form method="post" action="${pageContext.request.contextPath}/carOwner/update" class="pageForm required-validate"
          onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent" layoutH="56">
            <input type="hidden" name="carOwnerId" value="${carOwner.carOwnerId}"/>

            <p>
                <label>车主:</label>
                <input type="text" name="carOwnerName" value="${carOwner.carOwnerName}" readonly="readonly"/>
            </p>

            <p>
                <label>手机号:</label>
                <input type="text" name="carOwnerPhone" value="${carOwner.carOwnerPhone}"/>
            </p>

            <p>
                <label>地址:</label>
                <input type="text" name="carOwnerAddress" value="${carOwner.carOwnerAddress}"/>
            </p>


            <p>
                <label>登记时间：</label>
                <%--<input type="text" id="buyDate" name="buyDate"--%>
                <%--onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>--%>

                <input type="text" name="inputTime" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                       value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${carOwner.inputTime}" />"
                       class="required" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <%--<span class="info">yyyy-MM-dd HH:mm:ss</span>--%>
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
