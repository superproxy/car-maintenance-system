<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<%--'command' 默认的 modelAttribute--%>
<%--<form:form method="POST" action="/template/edit" modelAttribute="orderEntity">--%>
<div class="pageContent">
    <%--<form name="form" action="/template/update" method="post"  >--%>

    <form method="post" action="${pageContext.request.contextPath}/template/update" class="pageForm required-validate"
          onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent" layoutH="56">
            <p>
                <label>单号:</label>
                <input type="text" name="buyId" value="${orderEntity.buyId}" readonly="readonly"/>
            </p>

            <p>
                <label>购买时间：</label>
                <%--<input type="text" id="buyDate" name="buyDate"--%>
                <%--onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>--%>
                <input type="text" name="buyDate" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                       value="${orderEntity.buyDate}" class="required" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <%--<span class="info">yyyy-MM-dd HH:mm:ss</span>--%>
            </p>

            <p>
                <label>录入时间：</label>
                <%--<input type="text" id="inputDate" name="inputDate"--%>
                <%--onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:'false',readOnly:'true'})"/>--%>
                <input type="text" name="inputDate" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                       value="${orderEntity.inputDate}" readonly="true" class="required"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <%--<span class="info">yyyy-MM-dd HH:mm:ss</span>--%>
            </p>

            <p>
                <label>总价：</label>
                <input type="text" id="totalPrice" name="totalPrice" value="${orderEntity.totalPrice}"/>
            </p>

            <p>
                <label>折扣：</label>
                <input type="text" id="discount" name="discount" value="${orderEntity.discount}"/>
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
