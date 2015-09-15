<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<div class="pageContent">
    <form method="post" action="${pageContext.request.contextPath}/carOwner/create" class="pageForm required-validate"
          onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent" layoutH="56">
            <p>
                <label>车主：</label>
                <input class="required" type="text" id="carOwnerName" name="carOwnerName">
            </p>


            <p>
                <label>手机号：</label>
                <input type="text" id="carOwnerPhone" name="carOwnerPhone">
            </p>

            <p>
                <label>地址：</label>
                <input type="textArea" id="carOwnerAddress" name="carOwnerAddress" width="200px">
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
