<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<div class="pageContent">
    <form method="post" action="${pageContext.request.contextPath}/car/create" class="pageForm required-validate"
          onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent" layoutH="56">
            <p>
                <label>车牌号：</label>
                <input class="required" type="text" id="carCard" name="carCard">
            </p>

            <p>
                <label>车主：</label>
                <input id="carOwnerId" name="carOwnerId" value="" type="hidden"/>
                <input type="text" id="carOwnerName" name="carOwnerName" postField="carOwnerName"
                <%--显示的字段--%>
                       suggestFields="carOwnerName,carOwnerPhone, carOwnerAddress"
                       suggestUrl="${pageContext.request.contextPath}/carOwner/queryCarOwner"/>
            </p>

            <p>
                <label>车辆类型：</label>
                <input type="text" id="carType" name="carType">
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
