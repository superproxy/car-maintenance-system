<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<div class="pageContent">
    <form method="post" action="${pageContext.request.contextPath}/maintance/create" class="pageForm required-validate"
          onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent" layoutH="56">
            <dl class="nowrap">
                <label>维修单号：</label>
                <input class="required" type="text" id="maintanceId" name="maintanceId" value="${maintance.maintanceId}"
                       readonly="true">
            </dl>
            <dl class="nowrap">


                <label>车牌号：</label>
                <input class="required" type="text" id="carCard" name="carCard" postField="carCard"
                <%--显示的字段--%>
                       suggestFields="carCard"
                       suggestUrl="${pageContext.request.contextPath}/car/queryCarCard"/>
            </dl>
            <dl class="nowrap">


                <label>车主：</label>
                <input id="carOwnerId" name="carOwnerId" value="" type="hidden"/>
                <input type="text" id="carOwnerName" name="carOwnerName" postField="carOwnerName"
                <%--显示的字段--%>
                       suggestFields="carOwnerName,carOwnerPhone, carOwnerAddress"
                       suggestUrl="${pageContext.request.contextPath}/carOwner/queryCarOwner"/>
                <%--<a class="btnLook" href="${pageContext.request.contextPath}/carOwner/queryCarOwner">查找带回</a>--%>
                <%--<span class="info">(suggest+lookup)</span>--%>
            </dl>
            <dl class="nowrap">

                <label>维修原因：</label>
                <textarea id="failReason" name="failReason"></textarea>
                <%--<input class="required" type="text" id="failReason" name="failReason">--%>
            </dl>
            <dl class="nowrap">

                <label>维修类型：</label>
                <select id="failType" name="failType" class="required">
                    <option value="1">保养</option>
                    <option value="2">维修</option>
                </select>
            </dl>
            <dl class="nowrap">
                <label>接车时间：</label>
                <input type="text" name="receiveTime" class="date" dateFmt="yyyy-MM-dd HH:mm:ss"
                       class="required" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </dl>
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
